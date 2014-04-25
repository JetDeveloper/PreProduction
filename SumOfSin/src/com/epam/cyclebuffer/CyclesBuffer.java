/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.cyclebuffer;

/**
 *
 * @author Dmytro_Svynarenko
 */
public interface CyclesBuffer<T> {
     public void push(T value);
     public  T pop();
}
