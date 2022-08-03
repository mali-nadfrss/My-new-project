package com.mali.ds.searchNsort;

public class BinarySearch {
  public static int search(int[] arr, int n, int k) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == k) {
        return mid;
      } else if (arr[mid] > k) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    System.out.print(search(arr, 5, 4));
  }
}
