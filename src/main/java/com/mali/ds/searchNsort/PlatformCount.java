package com.mali.ds.searchNsort;

import java.util.Arrays;

public class PlatformCount {

    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int ans = 0;
        int temp = 0;
        for (int i = 0, j = 0; i < n; ) {
            if (arr[i] < dep[j]) {
                temp++;
                if (temp > ans) {
                    ans = temp;
                }
                i++;
            } else {
                temp--;
                j++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] brr = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, brr, 6));
    }
}
