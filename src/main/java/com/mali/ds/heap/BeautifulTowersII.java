package com.mali.ds.heap;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* https://leetcode.com/contest/weekly-contest-364/problems/beautiful-towers-ii/ */
public class BeautifulTowersII {

  public static long maximumSumOfHeights(List<Integer> maxHeights) {

    long ans = 0;
    Stack<Integer> stack = new Stack<>();
    int n = maxHeights.size();
    long[] leftSum = new long[n];
    long[] rightSum = new long[n];
    stack.add(0);
    leftSum[0] = maxHeights.get(0);
    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) stack.pop();
      if (stack.isEmpty()) {
        leftSum[i] = (i + 1) * maxHeights.get(i);
      } else {
        leftSum[i] = leftSum[stack.peek()] + (i - stack.peek()) * maxHeights.get(i);
      }
      stack.add(i);
    }
    stack.clear();
    stack.add(n - 1);
    rightSum[n - 1] = maxHeights.get(n - 1);
    for (int i = n - 2; i >= 0; i--) {
      while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) stack.pop();
      if (stack.isEmpty()) {
        rightSum[i] = (n-i) * maxHeights.get(i);
      } else {
        rightSum[i] = rightSum[stack.peek()] + (stack.peek()-i) * maxHeights.get(i);
      }
      stack.add(i);
    }
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, leftSum[i] + rightSum[i] - maxHeights.get(i));
    }
    return ans;
  }

  public static void main(String[] args) {
    Integer[] maxHeights = {6, 5, 3, 9, 2, 7};
    System.out.println(maximumSumOfHeights(Arrays.asList(maxHeights)));
  }
}
