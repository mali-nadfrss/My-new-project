package com.mali.ds.arrays;

/* https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
* hard */
public class FindMissing {

  static int findMissing(int arr[], int size) {
    for (int i = 1; i < size; ) {
      if (arr[i] > 0 && arr[i] <= size && arr[i] != arr[arr[i] - 1]) {
        int temp = arr[arr[i] - 1];
        arr[arr[i] - 1] = arr[i];
        arr[i] = temp;
      } else {
        i++;
      }
    }

    for (int i = 0; i < size; i++) {
      if ((i + 1) != arr[i]) {
        return i + 1;
      }
    }
    return size + 1;
  }

  public static void main(String[] args) {
    int[] arr = {
      -25, 38, 24, -17, 7, 31, 43, 8, 20, 49, -33, -11, 19, 13, -28, 44, 23, -3, -19, 12, 32, 40,
      42, 41, 7, -35, -29, 7, 24, 41, -3, 1, -19, -29, -13, -10, 4, -20, 48
    };
    System.out.println(findMissing(arr, arr.length));
  }
}
