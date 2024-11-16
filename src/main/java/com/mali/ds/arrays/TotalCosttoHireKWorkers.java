package com.mali.ds.arrays;

import java.util.PriorityQueue;

/* https://leetcode.com/contest/weekly-contest-318/problems/total-cost-to-hire-k-workers/ */
public class TotalCosttoHireKWorkers {

  public static long totalCost(int[] costs, int k, int candidates) {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    long ans = 0;
    int i = 0;
    int j = costs.length - 1;
    for (; i < candidates ; i++) {
      pq.add(costs[i]);

    }

    for (int l = 0 ; l < candidates && i < j ; l++, j--){
      pq1.add(costs[j]);
    }

    for (int m = 0; m < k; m++) {
      if (pq.isEmpty() && !pq1.isEmpty()){
        ans += pq1.poll();
      } else if (pq1.isEmpty() && !pq.isEmpty()){
        ans += pq.poll();
      }
      else if (!pq.isEmpty() && pq.peek() <= pq1.peek()) {
        ans += pq.poll();
        if (i <= j) {
          pq.add(costs[i++]);
        }
      } else if(!pq1.isEmpty()){
        ans += pq1.poll();
        if (i <= j) {
          pq1.add(costs[j--]);
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {

    int[] costs = {48};
    int k = 1;
    int candidates = 1;
    System.out.println(totalCost(costs, k, candidates));
  }
}
