/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.sinsum;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
        List<Thread> threads = new LinkedList<>();
        List<SinSum> runnables = new LinkedList<>();
        int distance = (int) ((Math.abs(rightBount - leftBound)) / numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            Thread current;
            SinSum sinSum;
            if (i == numberOfThreads - 1 && numberOfThreads != 1) {
                sinSum = new SinSum(leftBound + distance * i + 1, rightBount+1);
                current = new Thread(sinSum);
            } else if (i == numberOfThreads - 1 && numberOfThreads == 1) {
                sinSum =new SinSum(leftBound + distance * i, rightBount+1);
                current = new Thread(sinSum);
            } else if (i == 0) {
                sinSum =new SinSum(leftBound + distance * i,
                        leftBound + distance * (i + 1));
                current = new Thread(sinSum);
            } else {
                sinSum =new SinSum(leftBound + distance * i + 1,
                        leftBound + distance * (i + 1));
                current = new Thread(sinSum);
            }

            current.start();
            threads.add(current);
            runnables.add(sinSum);
        }
        for (int i=0; i<threads.size(); i++) {
            try {
                threads.get(i).join();
                result += runnables.get(i).getResult();
            } catch (InterruptedException ex) {
                Logger.getLogger(CallableSinSum.class.getName()).log(Level.SEVERE, null, ex);
            } 

        }
       
        time = System.nanoTime() - time;
        return result;
    }

    @Override
    public long getTimeOfCalculation() {
       return time;
    }
    
}
