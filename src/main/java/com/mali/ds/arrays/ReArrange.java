package com.mali.ds.arrays;

/* https://www.geeksforgeeks.org/rearrange-given-array-place/
* hard */
public class ReArrange {

    static void arrange(long arr[], int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + (arr[(int) arr[i]] % n) * n;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }
    }
}
