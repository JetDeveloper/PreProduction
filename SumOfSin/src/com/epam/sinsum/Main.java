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
        for (int i = 1; i <= 10; i++) {
            MultiThreadSinSum callable = new CallableSinSum(leftBorded, rigthBorder, i);
            System.out.println("Callable [" + leftBorded + "," + rigthBorder+ "] " 
                    + "result: " + callable.calculate()
                    + " threads: " + i + " time: "
                    + callable.getTimeOfCalculation());
        }

    }
}
