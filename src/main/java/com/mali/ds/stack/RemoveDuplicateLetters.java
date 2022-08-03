package com.mali.ds.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* https://leetcode.com/problems/remove-duplicate-letters/
 * medium
 * */
public class RemoveDuplicateLetters {
  public static String removeDuplicateLetters(String s) {
    Stack<Character> stack = new Stack<>();
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.computeIfPresent(c, (k, v) -> v + 1);
      map.computeIfAbsent(c, v -> 1);
    }

    boolean[] visited = new boolean[256];
    for (char c : s.toCharArray()) {
      if (visited[c]) {
        map.computeIfPresent(c, (k, v) -> v - 1);
        continue;
      }
      while (!stack.isEmpty() && stack.peek() >= c) {
        if (map.get(stack.peek()) > 1) {
          map.computeIfPresent(stack.peek(), (k, v) -> v - 1);
          visited[stack.peek()] = false;
          stack.pop();

        } else {
          break;
        }
      }
      stack.push(c);
      visited[c] = true;
    }
    StringBuilder ans = new StringBuilder();
    while (!stack.isEmpty()) {
      ans.insert(0, stack.pop());
    }
    return ans.toString();
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicateLetters("cbacdcbc"));
  }
}
