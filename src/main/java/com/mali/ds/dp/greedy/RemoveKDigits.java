package com.mali.ds.dp.greedy;

import java.util.Stack;

/* https://leetcode.com/problems/remove-k-digits/
 * medium
 * */
public class RemoveKDigits {

  /* first intuition for such problems should be stack
   * todo */
  public static String removeKdigits(String num, int k) {

    if (num.length() == k) return "0";
    Stack<Character> stack = new Stack();
    for (char n : num.toCharArray()) {
      while (!stack.isEmpty() && stack.peek() > n && k > 0) {
        stack.pop();
        k -= 1;
      }
      stack.push(n);
      if (stack.size() == 1 && stack.peek() == '0') {
        stack.pop();
      }
    }

    StringBuilder ans = new StringBuilder();
    while (!stack.isEmpty()) {
      ans.append(stack.pop());
    }
    if (ans.length() == 0) {
      return "0";
    }
    return ans.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(removeKdigits("10", 1));
  }
}
