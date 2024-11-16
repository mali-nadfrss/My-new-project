package com.mali.ds.stack;

import java.util.Stack;

/* https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/ */
public class ReverseSubstringsBetweenEachPairofParentheses {

  public static String reverseParenthesesMine(String s) {
    int len = s.length();
    int begin = 0;
    int end = 0;

    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == '(') begin = i;
      if (s.charAt(i) == ')') {
        end = i;
        StringBuilder sb = new StringBuilder();
        return reverseParenthesesMine(
            s.substring(0, begin)
                + sb.append(s, begin + 1, end).reverse()
                + s.substring(end + 1, len));
      }
    }
    return s;
  }

  // lees solution just remember it :)
  public static String reverseParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    int len = s.length();
    int[] pairs = new int[len];

    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      }
      if (s.charAt(i) == ')') {
        pairs[i] = stack.pop();
        pairs[pairs[i]] = i;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0, d = 1; i < len; i += d) {
      if (s.charAt(i) == '(' || s.charAt(i) == ')') {
        i = pairs[i];
        d = -d;
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {

    System.out.println(reverseParentheses("(ed(et(oc))el)"));
    System.out.println(reverseParenthesesMine("(ed(et(oc))el)"));
  }
}
