/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.cyclebuffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class CyclesBufferConcurrent<T> implements CyclesBuffer<T> {

    private T[] buffer;
    private int head;
    private int tail;
    private int size;
    private ReentrantLock lock;
    private Condition readCondition;
    private Condition writeCondition;

    public CyclesBufferConcurrent(int lenght) {
        buffer = (T[]) new Object[lenght];
        head = tail = size = 0;
        lock = new ReentrantLock();
        readCondition = lock.newCondition();
        writeCondition = lock.newCondition();
    }

    @Override
    public void push(T value) {
        try {
             lock.lock();
            while (size >= buffer.length) {
                System.out.println("Buffer is full. Waiting for pop");
                writeCondition.await();
            }
            if (head != (tail - 1)) {
                buffer[head++] = value;
                size++;
                System.out.println("Buffer size is " + size + " pushed el " + value.toString());
            }
            head = head % buffer.length;
            readCondition.signalAll();
          
        } catch (InterruptedException ex) {
            Logger.getLogger(CyclesBufferConcurrent.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             lock.unlock();
        }
    }

    @Override
    public  T pop() {
        T element = null;
         lock.lock();
        try {
            while (size == 0) {
                System.out.println("Buffer is empty. Waiting for push");
                readCondition.await();
            }

            int adjTail = tail > head ? tail - buffer.length : tail;
            if (adjTail < head) {
                element = (T) buffer[tail];
                buffer[tail] = null;
                tail++;
                size--;
                tail = tail % buffer.length;
                System.out.println("Buffer size is " + size + " poped el " + element.toString());
                  
            }
            writeCondition.signalAll(); 
        } catch (InterruptedException ex) {
            Logger.getLogger(CyclesBufferConcurrent.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
            return element;
        }
    }
}
