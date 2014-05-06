/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.cyclebuffer;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class Writer<T> implements Runnable{
    private CyclesBuffer<T> buffer;
    private int id;
    private T[] objects;

    public Writer(CyclesBuffer<T> buffer, int id, T[] objects) {
        this.buffer = buffer;
        this.id = id;
        this.objects = objects;
    }
    
    @Override
    public void run() {
         while(true) {
             T t = objects[new Random().nextInt(objects.length-1)];
             buffer.push(t);
             System.out.println("Writer thread " + id + " pushs " + t.toString());
            try {
                Thread.sleep(500); // give some time for readers
            } catch (InterruptedException ex) {
                Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
            }
         }       
    }
}
