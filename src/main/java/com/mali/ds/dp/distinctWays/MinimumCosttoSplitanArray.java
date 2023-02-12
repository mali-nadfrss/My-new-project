package com.mali.ds.dp.distinctWays;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-329/problems/minimum-cost-to-split-an-array/ */
public class MinimumCosttoSplitanArray {

  static int len = 0;

  public static int minCost(int[] nums, int k) {
    len = nums.length;
    k1 = k;
    int[][] ways = new int[len][len];
    for (int i = 0; i < len; i++) {
      ways[i][i] = k;
    }
    for (int i = 0; i < len; i++) {

      Map<Integer, Integer> map = new HashMap<>();
      for (int j = i; j < len; j++) {
        map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        if (map.get(nums[j]) > 1) {
          ways[i][j] = ways[i][j - 1] + 1;
        } else {
          ways[i][j] = j > i ? ways[i][j - 1] : k;
        }
      }
    }
    return recursion(0, ways);
  }

  static int k1;

  static int recursion(int start, int[][] ways) {
    if (start == len) return 0;
    int cost = 0;
    for (int i = start; i < len; i++) {
      cost += ways[start][i] + recursion(i + 1, ways);
    }
    return cost;
  }

  public static void main(String[] args) {
    System.out.println(minCost(new int[] {1, 2, 1, 2, 1}, 2));

    int k = 4;

    int[] gifts = new int[] {25, 64, 9, 4, 100};


    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i  : gifts) {
        pq.add(i);
    }

    long ans = 0;

    while(k > 0){
      int j = pq.poll();
      pq.add((int)Math.sqrt(j));
      k--;
    }

    while(!pq.isEmpty()){
      ans +=pq.poll();
    }
    System.out.println(ans);

  }
}
