/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.sinsum;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class CallableSinSum implements MultiThreadSinSum {

    private int leftBound;
    private int rightBount;
    private int numberOfThreads;
    private long time;

    public CallableSinSum(int leftBound, int rightBount, int numberOfThreads) {
        this.leftBound = leftBound;
        this.rightBount = rightBount;
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public double calculate() {
        time = System.nanoTime();
        double result = 0;
        ExecutorService pool = Executors.newFixedThreadPool(numberOfThreads);
        Set<Future<Double>> threads = new HashSet<>();
        int distance = (int) ((Math.abs(rightBount - leftBound)) / numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            Callable<Double> current;
            if (i == numberOfThreads - 1 && numberOfThreads != 1) {
                current = new SinSum(leftBound + distance * i + 1, rightBount+1);
                //System.out.println((leftBound + distance * i + 1) + ", " + rightBount);
            } else if (i == numberOfThreads - 1 && numberOfThreads == 1) {
                current = new SinSum(leftBound + distance * i, rightBount+1);
              //  System.out.println((leftBound + distance * i) + ", " + rightBount);
            } else if (i == 0) {
                current = new SinSum(leftBound + distance * i,
                        leftBound + distance * (i + 1));
              //  System.out.println(leftBound + distance * i + ", "
              //          + (leftBound + distance * (i + 1)));
            } else {
                current = new SinSum(leftBound + distance * i + 1,
                        leftBound + distance * (i + 1));
             //   System.out.println((leftBound + distance * i + 1) + ", "
             //           + (leftBound + distance * (i + 1)));
            }
            Future<Double> future = pool.submit(current);
            threads.add(future);
        }
        for (Future<Double> future : threads) {
            try {
                result += future.get().doubleValue();
            } catch (InterruptedException ex) {
                Logger.getLogger(CallableSinSum.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(CallableSinSum.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        time = System.nanoTime() - time;
        pool.shutdown();
        return result;
    }

    @Override
    public long getTimeOfCalculation() {
        return time;
    }
}
