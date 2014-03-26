/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.sinsum;

import java.util.concurrent.Callable;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class SinSum implements Callable <Double>, Runnable{

    private int leftBorder;
    private int rigthBorder;
    private double result;
   
   
    public SinSum(int leftBorder, int rigthBorder) {
        this.leftBorder = leftBorder;
        this.rigthBorder = rigthBorder;
    }

    public double getResult() {
        return result;
    }
    
    
    @Override
    public Double call() throws Exception {
        double deltaResult = 0;
        for(int i=leftBorder; i<rigthBorder; i++) {
            deltaResult += Math.sin(i);
        }
        return deltaResult;
    }

    @Override
    public void run() {
        double deltaResult = 0;
        for(int i=leftBorder; i<rigthBorder; i++) {
            deltaResult += Math.sin(i);
        }
        result = deltaResult;
    }
    
}
