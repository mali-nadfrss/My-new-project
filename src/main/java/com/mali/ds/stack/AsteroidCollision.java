package com.mali.ds.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* https://leetcode.com/problems/asteroid-collision/
 * medium */
public class AsteroidCollision {

  public static int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < asteroids.length; i++) {
      if (asteroids[i] > 0) {
        stack.add(asteroids[i]);
      } else {
        boolean add = true;
        while (!stack.isEmpty()) {
          if (stack.peek() == Math.abs(asteroids[i])){
            add = false;
            stack.pop();
            break;
          }
          if (stack.peek() > Math.abs(asteroids[i])) {
            break;
          }
          stack.pop();
        }
        if (stack.isEmpty() && add) list.add(asteroids[i]);
      }
    }

    list.addAll(stack);

    int[] ans = new int[list.size()]   ;
    int k = 0;
    for(int i  : list){
      ans[k++]= i;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(asteroidCollision(new int[] {-20, 20, -20}));
  }
}
