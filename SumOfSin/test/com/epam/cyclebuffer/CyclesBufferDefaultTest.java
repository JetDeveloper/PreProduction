/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.cyclebuffer;

import junit.framework.Assert;
import org.junit.Test;


/**
 *
 * @author Dmytro_Svynarenko
 */
public class CyclesBufferDefaultTest {
    
    @Test
    public void testPush() {
        int size = 1;
        CyclesBufferDefault<Integer> cbd = new CyclesBufferDefault<>(5);
        cbd.push(100500);
        Assert.assertEquals(size, cbd.getSize());
    }

    @Test
    public void testPop() {
        int expected = 100500;
        CyclesBufferDefault<Integer> cbd = new CyclesBufferDefault<>(5);
        cbd.push(expected);
        int actual = cbd.pop();
        Assert.assertEquals(expected, actual);
    }
   
//    @Test(expected = BufferUnderflowException.class)
//    public void testPopEmpty() {
//        int expected = 0;
//        CyclesBufferDefault<Integer> cbd = new CyclesBufferDefault<>(5);
//        int actual = cbd.pop();
//        Assert.assertEquals(expected, actual);
//    }
    
    @Test
    public void testPopCoupleElements() {
        int expected = 100500;
        CyclesBufferDefault<Integer> cbd = new CyclesBufferDefault<>(5);
        cbd.push(expected);
        cbd.push(10);
        cbd.push(18);
        int actual = cbd.pop();
        Assert.assertEquals(expected, actual);
    }
//    @Test(expected = BufferOverflowException.class)
//    public void testPushOverflow() {
//        CyclesBufferDefault<Integer> cbd = new CyclesBufferDefault<>(3);
//        cbd.push(1);
//        cbd.push(10);
//        cbd.push(18);
//        cbd.push(20);
//        cbd.push(21);
//    }
}
