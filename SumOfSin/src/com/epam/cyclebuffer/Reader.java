/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.cyclebuffer;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class Reader<T> implements Runnable {

    private CyclesBuffer<T> reader;
    private int id;

    public Reader(CyclesBuffer<T> reader, int id) {
        this.reader = reader;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            T t = reader.pop();
            if (t != null) {
                System.out.println("Reader thread " + id + " gets " + t.toString());
            }
        }
    }
}
