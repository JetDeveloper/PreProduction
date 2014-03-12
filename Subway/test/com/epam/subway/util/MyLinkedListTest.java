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
   
        list.addFirst("5");
        String actual = list.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void AddLastItemToNotEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "MyLinkedList{5, 9}";
   
        list.addFirst("5");
        list.addLast("9");
        
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
        list.addLast("5");
        
        // length is 1, so 10 is out of range
        String actual = list.get(10).toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void AddOnFirstPositionInsertToNotEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "MyLinkedList{-, 5, 9, 6, 7}";
        list.addLast("5");
        list.addLast("9");
        list.addLast("6");
        list.addLast("7");
        
        list.add("-",0);
        String actual = list.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void AddOnCentralPositionInsertToNotEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "MyLinkedList{5, 9, -, 6, 7}";
        list.addLast("5");
        list.addLast("9");
        list.addLast("6");
        list.addLast("7");
        
        list.add("-",list.getLength()/2);
        String actual = list.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void AddOnEndPositionInsertToNotEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "MyLinkedList{5, 9, 6, 7, -}";
        list.addLast("5");
        list.addLast("9");
        list.addLast("6");
        list.addLast("7");
        
        list.add("-",list.getLength());
        String actual = list.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void DeleteElementOutOfUpperRangeNonEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addLast("5");
        list.addLast("4");
        list.addLast("7");
        list.delete(5);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void DeleteElementOutOfLowerRangeNonEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addLast("5");
        list.addLast("4");
        list.addLast("7");
        list.delete(-10);
    }
    
    @Test
    public void DeleteFirstNotEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "MyLinkedList{9, 6, 7}";
        list.addLast("5");
        list.addLast("9");
        list.addLast("6");
        list.addLast("7");
        
        list.delete(0);
        String actual = list.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void DeleteLastNotEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "MyLinkedList{5, 9, 6}";
        list.addLast("5");
        list.addLast("9");
        list.addLast("6");
        list.addLast("7");
        
        list.delete(list.getLength()-1);
        String actual = list.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void DeleteCenterNotEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "MyLinkedList{5, 9, 7, 8}";
        list.addLast("5");
        list.addLast("9");
        list.addLast("6");
        list.addLast("7");
        list.addLast("8");
        
        list.delete(list.getLength()/2);
        String actual = list.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void DeleteSecondNotEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        String expected = "MyLinkedList{5, 6, 7, 8}";
        list.addLast("5");
        list.addLast("9");
        list.addLast("6");
        list.addLast("7");
        list.addLast("8");
        
        list.delete(1);
        String actual = list.toString();
        
        assertEquals(expected, actual);
    }
}
