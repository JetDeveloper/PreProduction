/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.biginteger;

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class Main {

    public static void main(String[] args) {
        final AtomicBigInteger atomicBigInteger = new AtomicBigInteger(BigInteger.ONE);

        class ThreadGetNext implements Runnable {

            private int threadID;

            public ThreadGetNext(int threadID) {
                this.threadID = threadID;
            }

            @Override
            public void run() {
                while (true) {
                    atomicBigInteger.incrementAndGet();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        for (int i = 1; i <= 10; i++) {
            new Thread(new ThreadGetNext(i)).start();
        }
    }
}
