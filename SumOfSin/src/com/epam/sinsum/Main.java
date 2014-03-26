/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.sinsum;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int leftBorded = -100;
        int rigthBorder = 100;
        double timeCallable[] = new double[10];
        double timeRunnable[] = new double[10];
        for (int j = 0; j < 50; j++) {

            for (int i = 1; i <= 10; i++) {
                MultiThreadSinSum callable = new CallableSinSum(leftBorded, rigthBorder, i);
                callable.calculate();
                /*System.out.println("Callable [" + leftBorded + "," + rigthBorder + "] "
                        + "result: " + callable.calculate()
                        + " threads: " + i + " time: "
                        + callable.getTimeOfCalculation());*/
                timeCallable[i - 1] += callable.getTimeOfCalculation() / 50.0;
            }
            for (int i = 1; i <= 10; i++) {
                MultiThreadSinSum runnable = new RunnableSinSum(leftBorded, rigthBorder, i);
                runnable.calculate();
                /*System.out.println("Callable [" + leftBorded + "," + rigthBorder + "] "
                        + "result: " + runnable.calculate()
                        + " threads: " + i + " time: "
                        + runnable.getTimeOfCalculation());*/
                timeRunnable[i - 1] += runnable.getTimeOfCalculation() / 50.0;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + (i + 1) + " Callable time "
                    + timeCallable[i] + " Runnable time " + timeRunnable[i]);

        }

    }
}
