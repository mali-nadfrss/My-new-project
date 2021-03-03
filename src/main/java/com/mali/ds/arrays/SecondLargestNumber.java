package com.mali.ds.arrays;

public class SecondLargestNumber {

    void secondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int ans_frequency = 0;
        int largest_frequency = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                ans = largest;
                ans_frequency = largest_frequency;
                largest = arr[i];
                largest_frequency = 1;
            } else if (arr[i] < largest && arr[i] > ans) {
                ans = arr[i];
                ans_frequency = 1;
            } else if (arr[i] == largest) {
                largest_frequency++;
            } else if (arr[i] == ans) {
                ans_frequency++;
            }
        }
        System.out.println("second largest" + ans);
    }
}
