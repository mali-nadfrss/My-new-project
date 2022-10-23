package com.mali.ds.arrays;

import java.util.Stack;

/* https://leetcode.com/problems/construct-smallest-number-from-di-string/
 * medium */
public class ConstructSmallestNumberFromDIString {

  public static String smallestNumber(String pattern) {

    char[] cArr = pattern.toCharArray();

    int i = 1;

    Stack<Integer> stack = new Stack<>();
    stack.add(i++);
    for (int j = 0; j < cArr.length; j++) {

      if (cArr[j] == 'D') {
        Stack<Integer> tempStack = new Stack<>();
        int l = j;
        while (!stack.isEmpty() && cArr[l] == 'D') {
          tempStack.add(stack.pop());
          l--;
        }
        stack.add(i++);
        while (!tempStack.isEmpty()) {
          stack.add(tempStack.pop());
        }
      } else {
        stack.add(i++);
      }
    }
    String ans = "";
    while (!stack.isEmpty()) {
      ans = stack.pop() + ans;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(smallestNumber("DDD"));
  }
}
