/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.sinsum;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class SinSumTest {

    @Test
    public void callWithZeroSumOneThread() throws Exception {
        Callable<Double> test = new SinSum(-1, 1);
        double expected = 0;
        
        ExecutorService ex= Executors.newFixedThreadPool(1);
        Future<Double> future = ex.submit(test);
        
        double actual = future.get().doubleValue();
        
        assertEquals(expected, actual, 1);
    }
    
    @Test
    public void callWithZeroSumTwoThreads() throws Exception {
        double expected = 0;
        
        ExecutorService ex= Executors.newFixedThreadPool(2);
        Callable<Double> test1 = new SinSum(-1, 0);
        Callable<Double> test2 = new SinSum(1, 1);
        Future<Double> future1 = ex.submit(test1);
        Future<Double> future2 = ex.submit(test2);
        double actual = future1.get().doubleValue();
        actual += future2.get().doubleValue();
        
        assertEquals(expected, actual, 1);
    }
    
    @Test
    public void callWithNonZeroSumOneThread() throws Exception {
        Callable<Double> test = new SinSum(-1, 0);
        double expected = Math.sin(-1) + Math.sin(0);
        
        ExecutorService ex= Executors.newFixedThreadPool(1);
        Future<Double> future = ex.submit(test);
        
        double actual = future.get().doubleValue();
        
        assertEquals(expected, actual, 1);
    }
    
    @Test
    public void callWithNonZeroSumOneElementOneThread() throws Exception {
        Callable<Double> test = new SinSum(-1, -1);
        double expected = Math.sin(-1);
        
        ExecutorService ex= Executors.newFixedThreadPool(1);
        Future<Double> future = ex.submit(test);
        
        double actual = future.get().doubleValue();
        
        assertEquals(expected, actual, 1);
    }
}
