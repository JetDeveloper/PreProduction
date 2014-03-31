/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.generics.array2collection;

import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class ArrayCollections {

    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        // for( T temp: a) {
        //    c.add(temp);
        // }
        c.addAll(Arrays.asList(a));
    }

    public static void main(String[] args) {
    }
}
