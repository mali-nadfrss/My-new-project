package com.mali.ds.searchNsort;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j > 0 ; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else{
                    break;
                }

            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 5, 2, 9};
        sort(arr);
    }
}
