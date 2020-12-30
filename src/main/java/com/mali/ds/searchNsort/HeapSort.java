package com.mali.ds.searchNsort;

public class HeapSort {

    static void maxHeap(int[] arr, int i, int n) {
        int k = 2 * i;
        if (k <= n) {
            int l = k - 1 >= 0 ? arr[k - 1] : Integer.MIN_VALUE;
            int r = k + 1 <= n ? arr[k] : Integer.MIN_VALUE;

            if (i - 1 >= 0 && l >= r && l > arr[i - 1]) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[k - 1];
                arr[k - 1] = temp;
                maxHeap(arr, k, n);
            } else if (i - 1 >= 0 && r > arr[i - 1]) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[k];
                arr[k] = temp;
                maxHeap(arr, k + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            maxHeap(arr, i, n);
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
