package com.mali.ds.searchNsort;

public class RotatedSearch {

    static int search(int array[], int target) {
        // code here
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < array[high]) {
                if (array[mid] < target && array[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (array[low] < array[mid]) {
                if (array[mid] > target && array[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        System.out.print(search(arr, 10));
    }
}
