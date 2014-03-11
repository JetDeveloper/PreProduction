/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway;

import com.epam.subway.util.MyLinkedList;
import java.util.LinkedList;
import java.util.List;

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
        List<Integer> l = new LinkedList<>();
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("44");
        myList.add("55",2);
        System.out.println(myList);
        
    }
}
