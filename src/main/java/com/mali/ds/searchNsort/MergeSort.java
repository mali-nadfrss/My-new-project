package com.mali.ds.searchNsort;

public class MergeSort {
    static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (high + low) / 2;
            sort(arr, low, middle);
            sort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    static void merge(int[] arr, int low, int middle, int high) {
        int l = middle - low + 1;
        int r = high - middle;
        int[] left = new int[l];
        int[] right = new int[r];
        for (int i = 0; i < l; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < r; i++) {
            right[i] = arr[middle + i + 1];
        }
        int i = 0, j = 0, k = low;
        while (i < l && j < r) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < l) {
            arr[k++] = left[i++];
        }

        while (j < r) {
            arr[k++] = right[j++];
        }

    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        sort(arr, 0, 6);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
