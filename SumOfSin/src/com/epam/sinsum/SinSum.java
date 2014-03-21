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
public class SinSum implements Callable <Double>{

    private int leftBorder;
    private int rigthBorder;

    public SinSum(int leftBorder, int rigthBorder) {
        this.leftBorder = leftBorder;
        this.rigthBorder = rigthBorder;
    }
    
    
    @Override
    public Double call() throws Exception {
        double result = 0;
        for(int i=leftBorder; i<rigthBorder; i++) {
            result += Math.sin(i);
        }
        return result;
    }
    
}
