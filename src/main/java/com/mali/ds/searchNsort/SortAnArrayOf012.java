package com.mali.ds.searchNsort;

public class SortAnArrayOf012 {

    static void sortArray(int[] arr){
        int i = -1;
        int k = arr.length-1;
        for (int j = 0; j <= k; ) {
            if (arr[j] == 0){
                i++;
                swap(arr, i, j);
                j++;
            }
            if (arr[j] == 2){
                if(arr[k] == 2){
                    k--;
                }
                swap(arr, j , k);
                k--;
            }
            if (arr[j] == 1){
                j++;
            }
        }
    }

    static void swap(int[] arr, int i , int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 0, 1, 2, 0, 2, 2, 0};
        sortArray(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
