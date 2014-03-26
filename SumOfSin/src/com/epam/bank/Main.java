/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.bank;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        final Bank b = new Bank();
        class ThreadEmulateTransfer implements Runnable {

            private int threadID;

            @Override
            public void run() {
                while (true) {
                    try {
                        int first = new Random().nextInt(b.getAcounts().size());
                        int second = new Random().nextInt(b.getAcounts().size());
                        int amount = new Random().nextInt(500);
                        //System.out.println("Transfer between " + first
                       //         + " and " + second + " amount " + amount);
                        b.transfer(b.getAcounts().get(first),
                                b.getAcounts().get(second), amount);
                        System.out.println("Bank summ is " + b.calculateSum());
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        for (int i = 0; i < 500; i++) {
            new Thread(new ThreadEmulateTransfer()).start();
        }
    }
}
