package com.mali.ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class SecondLargestNumber {

    void secondLargest(int[] arr) {

        int largest = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int largest_frequency = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                ans = largest;
                largest = arr[i];
                largest_frequency = 1;
            } else if (arr[i] < largest && arr[i] > ans) {
                ans = arr[i];
            } else if (arr[i] == largest) {
                largest_frequency++;
            } else if (arr[i] == ans) {
            }
        }
        System.out.println("second largest" + ans);
    }
}
