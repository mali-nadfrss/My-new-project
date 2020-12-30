package com.mali.ds.arrays;

public class RotateArray {

    static void rotateArray(int[] arr, int d){
        int n = arr.length;
        reverse(arr, 0,n );
        reverse(arr, 0,n-1-d );
        reverse(arr, n-d,n-1 );
    }

    static void reverse(int[] arr, int start, int end){
        while (start< end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static void main(String[] args) {


        System.out.println();
    }
}
