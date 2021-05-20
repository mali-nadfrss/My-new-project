package com.mali.ds.greedy;

public class JumpGame {

  public static int minJumps(int[] nums) {
return 0;
  }

  public static boolean canJump(int[] nums) {
    int required = 0;

    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] > required) {
        required = 0;
      } else {
        required++;
      }
    }
    return required <= 0;
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 0, 4};
    System.out.println(canJump(nums));
  }
}
