package com.mali.ds.arrays;

import java.util.Stack;

/* https://leetcode.com/contest/weekly-contest-319/problems/number-of-subarrays-with-lcm-equal-to-k/ */
public class NumberofSubarraysWithLCMEqualtoK {

  public int subarrayLCM(int[] nums, int k) {
    int ans = 0;

    int start = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < nums.length; i++) {

      if (nums[i] == k) ans++;
      if (k % nums[i] == 0) {
        if (!stack.isEmpty() &&lcm(nums[i], stack.peek()) == k) {
          stack.pop();
          ans += i - start;
        }
        stack.add(nums[i]);
      } else {
        stack = new Stack<>();
        start = i + 1;
      }
    }
    return ans;
  }

  int gcd(int a, int b) {

    if (a == 0) return b;
    return gcd(b % a, a);
  }

  int lcm(int a, int b) {
    return (a / gcd(a, b)) * b;
  }

  public static void main(String[] args) {
    int[] amount = {2, 1, 1, 5};
    int k = 5;
    NumberofSubarraysWithLCMEqualtoK r = new NumberofSubarraysWithLCMEqualtoK();
    System.out.println(r.subarrayLCM(amount, k));
  }
}
