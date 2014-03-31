/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class Main {

    public static void main(String[] args) {
        int[] numbers = {45, 78, -10, 78, 14, 5, 8, 9, 11};
        System.out.println("Unsorted array: "
                + Arrays.toString(numbers));
        SortTask task = new SortTask(numbers);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(task);
        System.out.println("Sorted array: " + Arrays.toString(task.join()));

    }
}
