package com.mali.ds.stack;

import java.util.Arrays;
import java.util.Stack;

/* https://leetcode.com/problems/daily-temperatures/
medium */
public class DailyTemperatures {

  public static int[] dailyTemperatures(int[] temperatures) {
    int len = temperatures.length;
    int[] ans = new int[len];
    Stack<Integer> stack = new Stack<>();
    ans[len - 1] = 0;
    stack.push(len - 1);
    for (int i = len - 2; i >= 0; i--) {
      while (!stack.isEmpty()) {
        if (temperatures[stack.peek()] <= temperatures[i]) {
          stack.pop();
        } else {
          break;
        }
      }
      ans[i] = !stack.isEmpty() ? stack.peek() - i : 0;
      stack.push(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {89,62,70,58,47,47,46,76,100,70};
    System.out.print(Arrays.toString(dailyTemperatures(arr)));
  }


}
