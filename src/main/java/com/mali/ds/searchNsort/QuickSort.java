package com.mali.ds.searchNsort;

public class QuickSort {
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int i = low - 1;
        int pi = arr[high];
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pi) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        quickSort(arr, 0, 6);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
