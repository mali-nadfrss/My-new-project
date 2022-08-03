package com.mali.ds.dp.greedy;

import java.util.Stack;

/* https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * medium */
public class MinimumAddtoMakeParenthesesValid {
  public static int minAddToMakeValid(String s) {
    int ans = 0;
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (stack.isEmpty() && c == ')') {
        ans++;
      } else if (c == ')') {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return ans + stack.size();
  }

  public static void main(String[] args) {
    System.out.println(minAddToMakeValid("()()(()(()"));
  }
}
