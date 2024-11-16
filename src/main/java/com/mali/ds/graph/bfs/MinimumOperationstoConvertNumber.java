package com.mali.ds.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* https://leetcode.com/problems/minimum-operations-to-convert-number/submissions/ */
public class MinimumOperationstoConvertNumber {

  public static int minimumOperations(int[] nums, int start, int goal) {

    Queue<Integer> q = new LinkedList<>();
    q.add(start);

    int res = 1;
    int val = 0;

    Set<Integer> set = new HashSet<>();
    set.add(start);

    while (!q.isEmpty()) {

      int len = q.size();

      for (int i = 0; i < len; i++) {
        val = q.poll();
        if (val == goal) return res;
        if (!set.add(val) || val < 0 || val > 1000) {
          continue;
        }
        for (int j = 0; j < nums.length; j++) {
          q.add(val + nums[j]);
          q.add(val - nums[j]);
          q.add(val ^ nums[j]);
        }
      }
      res++;
    }
    if (val == goal) return res;
    return -1;
  }

  public static void main(String[] args) {
    int[] strs = {2, 8, 16};
    //System.out.println(minimumOperations(strs, 0, 1));
    String a = "abs";
    test(a);
    System.out.println(a);

  }

  public  static  void test(String a ){
    a = "pqr";
  }
}
