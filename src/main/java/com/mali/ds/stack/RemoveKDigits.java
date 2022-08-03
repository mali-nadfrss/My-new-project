package com.mali.ds.stack;

import java.util.Stack;

/* https://leetcode.com/problems/remove-k-digits/
 *
 * medium */
public class RemoveKDigits {

  /* monotonic stack --> strictly increasing or decreasing stack */
  public static String removeKdigits(String num, int k) {
    Stack<Character> stack = new Stack();
    String ans = "";
    stack.push(num.charAt(0));
    for (int i = 1; i < num.length(); i++) {
      while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
        stack.pop();
        k--;
      }
      stack.push(num.charAt(i));
      if (stack.size() == 1 && stack.peek() == '0') {
        stack.pop();
      }
    }
    while (k > 0 && !stack.isEmpty()) {
      stack.pop();
      k--;
    }
    while (!stack.isEmpty()) {
      ans = stack.pop() + ans;
    }
    while (ans.length() > 0 && ans.charAt(0) == '0') {
      ans = ans.substring(1);
    }
    if (ans.equals("")) return "0";
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(removeKdigits("1432219", 3));
    System.out.println(removeKdigits("10200", 1));
    System.out.println(removeKdigits("112", 1));
  }
}
