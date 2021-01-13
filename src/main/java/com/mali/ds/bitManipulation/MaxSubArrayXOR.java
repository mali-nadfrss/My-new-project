package com.mali.ds.bitManipulation;

import java.util.Arrays;

public class MaxSubArrayXOR {
    public static int maxSubArrayXOR(int set[], int n) {
        //add code here.
        Arrays.sort(set);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int temp = set[i] ^ set[i + 1];
            if (temp > ans) {
                ans = temp;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int set[] = {2, 4, 5};
        System.out.println(maxSubArrayXOR(set, 3));
    }
}
