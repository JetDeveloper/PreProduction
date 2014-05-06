/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.cyclebuffer;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class Main {
    public static void main(String[] args) {
        String[] words = {"1", "sdf", "342", "ff"};
        //CyclesBuffer<String> buffer = new CyclesBufferDefault<>(50);
       CyclesBuffer<String> buffer = new CyclesBufferConcurrent<>(50);
        new Thread( new Writer<>(buffer, 1, words)).start();
        new Thread( new Writer<>(buffer, 2, words)).start();
        new Thread( new Reader<>(buffer, 1)).start();
       // new Thread( new Reader<>(buffer, 2)).start();
      //  new Thread( new Reader<>(buffer, 3)).start();
    }
}
