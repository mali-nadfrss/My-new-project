package com.mali.ds.dp;

public class PartitionEqualSubsetSum {

  public  static boolean canPartition(int[] nums) {

    int sum = 0;
    for (int i : nums) {
      sum = sum + i;
    }

    if (sum % 2 != 0) {
      return false;
    }

    boolean[] arr = new boolean[sum / 2 + 1];
    arr[0] = true;
    for (int i : nums) {

      for (int j = sum / 2; j >= i; j--) {
        arr[j] = arr[j] || arr[j - i];
      }
    }
    return arr[sum / 2];
  }

  public static void main(String[] args) {
    int[] nums = new int[] {5, 1, 11, 5};
    System.out.println(canPartition(nums));
  }

}
