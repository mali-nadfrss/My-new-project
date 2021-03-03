package com.mali.ds.arrays;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int x = n - 1;
        int y = 0;

        while (y < m && x >= 0) {
            if (arr1[x] > arr2[y]) {
                int temp = arr1[x];
                arr1[x--] = arr2[y];
                arr2[y++] = temp;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
