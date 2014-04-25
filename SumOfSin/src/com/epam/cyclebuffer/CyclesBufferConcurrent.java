/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.cyclebuffer;

import java.util.concurrent.locks.Lock;
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
    private ReentrantReadWriteLock rwl;
    Lock read;
    Lock write;

    public CyclesBufferConcurrent(int lenght) {
        buffer = (T[]) new Object[lenght];
        head = tail = size = 0;
        rwl = new ReentrantReadWriteLock();
        read = rwl.readLock();
        write = rwl.writeLock();
    }

    @Override
    public void push(T value) {
        write.lock();
        try {
            if (size >= buffer.length) {
                System.out.println("Buffer is full. Waiting for pop");
                return;
            }
            if (head != (tail - 1)) {
                buffer[head++] = value;
                size++;
                System.out.println("Buffer size is " + size + " pushed el " + value.toString());
            }
            head = head % buffer.length;
        } finally {
            write.unlock();
        }
    }

    @Override
    public T pop() {
        read.lock();
        try {
            if (size == 0) {
                System.out.println("Buffer is empty. Waiting for push");
                return null;
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
            return t;
        } finally {
            read.unlock();
        }
    }
}
