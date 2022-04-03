package com.mali.ds.dp.greedy;

/* https://leetcode.com/problems/previous-permutation-with-one-swap/
 * medium */
public class PreviousPermutationWithOneSwap {
  public static int[] prevPermOpt1(int[] arr) {

    if (arr.length <= 1) return arr;
    int max = -1;
    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i] < arr[i - 1]) {
        max = i - 1;
        break;
      }
    }

    if (max >= 0) {
      for (int i = arr.length - 1; i > max; i--) {
        if (arr[i] < arr[max] && arr[i] != arr[i - 1]) {
          int temp = arr[i];
          arr[i] = arr[max];
          arr[max] = temp;
          break;
        }
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    for (int i : prevPermOpt1(new int[] {3, 1, 1, 3})) {
      System.out.println(i);
    }
  }
}
