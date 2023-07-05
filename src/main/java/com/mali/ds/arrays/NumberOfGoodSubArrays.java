package com.mali.ds.arrays;

public class NumberOfGoodSubArrays {

  /* [0, 0, 1, 0, 1] -> find no.of good sub arrays
      good sub array is an array with atleast 1
  */

  static int find(int[] nums) {
    int len = nums.length;
    int ans = count(len);
    int start = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] == 1) {
        start = i + 1;
      } else {
        ans -= i - start + 1;
      }
    }
    return ans;
  }

  static int count(int len) {
    int ans = 0;
    for (int i = 1; i <= len; i++) {
      ans += i;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {0, 0, 1, 0, 1};
    System.out.println(find(arr));
  }
}
