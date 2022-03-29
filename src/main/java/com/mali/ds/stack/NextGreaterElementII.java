package com.mali.ds.stack;

import java.util.*;

/* https://leetcode.com/problems/next-greater-element-ii/
 * medium
 *  */
public class NextGreaterElementII {

  /* Monotonic stack --> strictly increasing/decreasing stack*/
  public static int[] nextGreaterElements(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] ans = new int[nums.length];
    int n = nums.length;

    // in stack store indexes not values
    for (int i = 0 ; i < 2*n ; i++) {
      while (!stack.isEmpty() && stack.peek() < nums[i%n]  ) {
        ans[i%n] = i;
      }
      stack.push(n);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nextGreaterElements(new int[] {100,1,11,1,120,111,123,1,-1,-100})));
  }
}
