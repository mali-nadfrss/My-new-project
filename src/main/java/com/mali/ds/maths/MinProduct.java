package com.mali.ds.maths;

public class MinProduct {
  int findMinProduct(int[] arr) {

    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    int min3 = Integer.MAX_VALUE;
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > min3 && arr[i] < max2) {
      } else {
        if (arr[i] > max2 && arr[i] < max1) {
          max2 = arr[i];
          continue;
        }
        if (arr[i] > max2 && arr[i] > max1) {
          max2 = max1;
          max1 = arr[i];
          continue;
        }
        if (arr[i] < min3 && arr[i] > min2) {
          min3 = arr[i];
          continue;
        }
        if (arr[i] < min2 && arr[i] > min1) {
          min3 = min2;
          min2 = arr[i];
        } else {
          min3 = min2;
          min2 = min1;
          min1 = arr[i];
        }
      }
    }

    int prod1 = min1 * min2 * min3;
    int prod2 = min1 * max2 * max1;
    return Integer.min(prod1, prod2);
  }
}
