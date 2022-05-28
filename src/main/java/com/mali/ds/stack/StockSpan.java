package com.mali.ds.stack;

import java.util.Stack;

/* medium 4
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 * */
public class StockSpan {

  static int[] calculateSpan(int price[], int n, int S[]) {

    Stack<Integer> s = new Stack<>();
    int[] ans = new int[n];
    ans[0] = 1;
    s.push(0);
    for (int i = 1; i < n; i++) {
      while (!s.isEmpty() && price[s.peek()] <= price[i]) {
        s.pop();
      }
      ans[i] = s.isEmpty() ? i + 1 : i - s.peek();
      s.push(i);
    }
    return ans;
  }
}
