package com.mali.ds.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* https://leetcode.com/problems/asteroid-collision/
 * medium */
public class AsteroidCollision {
  // todo needs some logic tweak, stack approach is fine
  public static int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < asteroids.length; i++) {
      if (asteroids[i] > 0) {
        stack.push(asteroids[i]);
      } else {
        if (stack.isEmpty()){
          list.add(asteroids[i]);
        }else {
        while (!stack.isEmpty()) {
          if (Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
            break;
          }
          stack.pop();
        }
        }
      }
    }
    if (stack.isEmpty() && list.size() == 0) return new int[] {};
    int[] ans = new int[stack.size()];
    for (int j = stack.size() - 1; j >= 0; j--) {
      ans[j] = stack.pop();
    }
    return ans;
  }

  public static void main(String[] args) {
    Arrays.stream(asteroidCollision(new int[] {10, 2, -5})).forEach(k -> System.out.println(k));
  }
}
