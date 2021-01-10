package com.mali.ds.searchNsort;

public class Peak {
    public static int peakElement(int[] arr, int n) {
        //add code here.
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid - 1 >= 0 && mid + 1 <= n - 1 && arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                return mid;
            } else if (mid - 1 >= 0 && mid + 1 <= n - 1 && arr[mid] < arr[mid - 1] && arr[mid + 1] < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.print(peakElement(arr, 3));
    }
}
