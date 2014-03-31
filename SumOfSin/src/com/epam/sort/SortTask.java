/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.sort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * 
 * @author Dmytro_Svynarenko
 */
public class SortTask extends RecursiveTask<int[]> {

    int[] arrayToDivide;

    public SortTask(int[] arrayToDivide) {
        this.arrayToDivide = arrayToDivide;
    }

    @Override
    protected int[] compute() {

        if (arrayToDivide.length > 1) {

            List<int[]> partitionedArray = partitionArray();

            SortTask task1 = new SortTask(partitionedArray.get(0));
            SortTask task2 = new SortTask(partitionedArray.get(1));
            invokeAll(task1, task2);

            //Wait for results from both the tasks
            int[] array1 = task1.join();
            int[] array2 = task2.join();

            //Initialize a merged array
            int[] mergedArray =
                    new int[array1.length + array2.length];

            mergeArrays(task1.join(), task2.join(), mergedArray);

            return mergedArray;
        }
        return arrayToDivide;
    }

    private List<int[]> partitionArray() {

        int[] partition1 = Arrays.copyOfRange(arrayToDivide, 0,
                arrayToDivide.length / 2);

        int[] partition2 = Arrays.copyOfRange(arrayToDivide,
                arrayToDivide.length / 2,
                arrayToDivide.length);
        return Arrays.asList(partition1, partition2);

    }

    /**
     * Marge arrays 
     * @param array1 first array 
     * @param array2 second array 
     * @param mergedArray result array
     */
    private void mergeArrays(
            int[] array1,
            int[] array2,
            int[] mergedArray) {

        int i = 0, j = 0, k = 0;

        while ((i < array1.length) && (j < array2.length)) {

            if (array1[i] < array2[j]) {
                mergedArray[k] = array1[i++];
            } else {
                mergedArray[k] = array2[j++];
            }

            k++;
        }

        if (i == array1.length) {

            for (int a = j; a < array2.length; a++) {
                mergedArray[k++] = array2[a];
            }

        } else {

            for (int a = i; a < array1.length; a++) {
                mergedArray[k++] = array1[a];
            }

        }
    }
}