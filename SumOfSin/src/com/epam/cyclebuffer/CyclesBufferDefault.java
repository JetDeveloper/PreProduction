/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.cyclebuffer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class CyclesBufferDefault<T> implements CyclesBuffer<T> {

    private T[] buffer;
    private int head;
    private int tail;
    private int size;

    public CyclesBufferDefault(int lenght) {
        buffer = (T[]) new Object[lenght];
        head = tail = size = 0;
    }

    @Override
    public synchronized void push(T value) {
        while (size >= buffer.length) {
            try {
                System.out.println("Buffer is full. Waiting for pop");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CyclesBufferDefault.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (head != (tail - 1)) {
            buffer[head++] = value;
            size++;
            System.out.println("Buffer size is " + size + " pushed el " + value.toString());
        } 
        head = head % buffer.length;
        notifyAll();
    }

    @Override
    public synchronized T pop() {
        while(size==0) {
            try {
                System.out.println("Buffer is empty. Waiting for push");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CyclesBufferDefault.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        T t = null;
        int adjTail = tail > head ? tail - buffer.length : tail;
        if (adjTail < head) {
            t = (T) buffer[tail];
            buffer[tail] = null;
            tail++;
            size--;
            tail = tail % buffer.length;
            System.out.println("Buffer size is " + size + " poped el " + t.toString());
            
        } 
        notifyAll();
        return t;
    }

    public int getSize() {
        return size;
    }
}
