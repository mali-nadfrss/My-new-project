package com.mali.ds.searchNsort;

public class SortAnArrayOf012 {

    static void sortArray(int[] arr){
        int i = 0;
        int k = arr.length-1;
        for (int j = 0; j <=k; ) {
            if (arr[j] == 0){
                swap(arr, i, j);
                j++;
                i++;
            }
            else if (arr[j] == 2){
                swap(arr, j , k);
                k--;
            }
            else if (arr[j] == 1){
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
            System.out.println(1 << i);
        }
    }
}
