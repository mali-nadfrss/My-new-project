package com.mali.ds.heap;

import java.util.LinkedList;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/k-closest-points-to-origin/ */
public class KClosestPointstoOrigin {

  public static int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq =
        new PriorityQueue<>(
            (p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));

    for (int[] point : points) {
      pq.add(point);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    int[][] ans = new int[k][2];
    int i = 0;
    while (!pq.isEmpty()) {
      ans[i++] = pq.poll();
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] nums = {{3, 3}, {5, -1}, {-2, 4}};
    System.out.println(kClosest(nums, 2));
  }
}
