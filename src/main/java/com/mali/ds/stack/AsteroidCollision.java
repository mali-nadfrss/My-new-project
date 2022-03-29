package com.mali.ds.stack;

import java.util.Arrays;
import java.util.Stack;

/* https://leetcode.com/problems/asteroid-collision/
 * medium */
public class AsteroidCollision {
  // todo needs some logic tweak, stack approach is fine
  public static int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    stack.push(asteroids[0]);
    for (int i = 1; i < asteroids.length; i++) {
      if (stack.isEmpty()
          || (asteroids[i] > 0 && stack.peek() > 0)
          || (asteroids[i] < 0 && stack.peek() < 0)) {
        stack.push(asteroids[i]);
      } else if (stack.peek() < 0) {
        stack.push(asteroids[i]);
      } else {
        while (!stack.isEmpty()) {
          if (stack.pop() < -1 * asteroids[i]) stack.pop();
          else {
            stack.push(asteroids[i]);
            break;
          }
        }
      }
    }
    if (stack.isEmpty()) return new int[] {};
    int[] ans = new int[stack.size()];
    int i = 0;
    while (!stack.isEmpty()) {
      ans[i++] = stack.pop();
    }
    return ans;
  }

  public static void main(String[] args) {
    Arrays.stream(asteroidCollision(new int[] {5, 10, -5})).forEach(k -> System.out.println(k));
  }
}
