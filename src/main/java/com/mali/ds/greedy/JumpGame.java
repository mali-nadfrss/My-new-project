package com.mali.ds.greedy;

public class JumpGame {

  public static int minJumps(int[] nums) {

    int len = nums.length;
    int[] memory = new int[nums.length];
    memory[len - 1] = 0;
    for (int i = len - 1; i >= 0; i--) {
      memory[i] = calJumps(nums[i], memory, i);
    }
    return memory[0];
  }

  static int calJumps(int jumps, int[] memory, int i) {
    int min = Integer.MAX_VALUE;
    for (int j = 1; j <= jumps && (j + i) < memory.length; j++) {
      int temp = 1 + memory[i + j];
      if (min > temp) {
        min = temp;
      }
    }

    return min;
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
