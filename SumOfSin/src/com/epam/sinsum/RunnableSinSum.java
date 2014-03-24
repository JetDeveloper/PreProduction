/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.sinsum;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class RunnableSinSum implements MultiThreadSinSum{

    private int leftBound;
    private int rightBount;
    private int numberOfThreads;
    private long time;

    public RunnableSinSum(int leftBound, int rightBount, int numberOfThreads) {
        this.leftBound = leftBound;
        this.rightBount = rightBount;
        this.numberOfThreads = numberOfThreads;
    }
    
    @Override
    public double calculate() {
         time = System.nanoTime();
        double result = 0;
        Set<Thread> threads = new HashSet<>();
        int distance = (int) ((Math.abs(rightBount - leftBound)) / numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            Thread current;
            if (i == numberOfThreads - 1 && numberOfThreads != 1) {
                current = new Thread(new SinSum(leftBound + distance * i + 1, rightBount+1));
            } else if (i == numberOfThreads - 1 && numberOfThreads == 1) {
                current = new Thread(new SinSum(leftBound + distance * i, rightBount+1));
            } else if (i == 0) {
                current = new Thread(new SinSum(leftBound + distance * i,
                        leftBound + distance * (i + 1)));
            } else {
                current = new Thread(new SinSum(leftBound + distance * i + 1,
                        leftBound + distance * (i + 1)));
            }

            current.start();
            threads.add(current);
        }
        for (Thread future : threads) {
            try {
                future.join();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(CallableSinSum.class.getName()).log(Level.SEVERE, null, ex);
            } 

        }
        result = SinSum.getResult();
        time = System.nanoTime() - time;
        return result;
    }

    @Override
    public long getTimeOfCalculation() {
       return time;
    }
    
}
