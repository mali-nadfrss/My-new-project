package com.mali.ds.arrays;

public class Sort012 {

  public static char[] customReplace(char[] arr) {
    int end = arr.length - 1;
    int mid = 1;
    int i = 0;
    while (end > mid) {
      if (arr[i] == 'c') {
        arr[i] = arr[end];
        arr[end] = 'c';
        end--;
      } else if (arr[i] == 'b') {
        i++;
      } else if (arr[i] == 'a') {
          arr[i] = arr[mid];
          arr[mid] = 'a';
        mid++;
      }
    }

    return arr;
  }

  public static void main(String[] args) {

    System.out.println(customReplace(new String("aabbcc").toCharArray()));
  }
}
