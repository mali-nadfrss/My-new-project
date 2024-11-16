package com.mali.ds.stack;

import java.util.Arrays;
import java.util.Stack;

/* https://leetcode.com/problems/next-greater-element-iv/ */
public class NextGreaterElementIV {

  public static int[] secondGreaterElement(int[] nums) {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    int[] ans = new int[nums.length];
    Arrays.fill(ans, -1);

    for (int i = 0; i < nums.length; i++) {

      if (!s2.isEmpty() && nums[s2.peek()] < nums[i]) {
        ans[s2.pop()] = nums[i];
      }
      if (!s1.isEmpty() && nums[s1.peek()] < nums[i]) {
        s2.push(s1.pop());
      }
      s1.push(i);
    }
    return ans;
  }

  public static void main(String[] args) {

    System.out.println(secondGreaterElement(new int[] {2, 4, 0, 9, 6}));
  }
}
