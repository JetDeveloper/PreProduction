/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class MyLinkedListTest {
    
    @Test
    public void AddFirstItemToEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "MyLinkedList{5}";
   
        list.add("5");
        String actual = list.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void AddLastItemToNotEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "MyLinkedList{5, 9}";
   
        list.add("5");
        list.add("9");
        
        String actual = list.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void GetFirstItemEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "";
        
        // lebgth is 0, so 0 (first element) is out of range
        String actual =  list.get(0).toString();
        
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void GetElementOutOfRangeNonEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "";
        list.add("5");
        
        // length is 1, so 10 is out of range
        String actual = list.get(10).toString();
        
        assertEquals(expected, actual);
    }
}
