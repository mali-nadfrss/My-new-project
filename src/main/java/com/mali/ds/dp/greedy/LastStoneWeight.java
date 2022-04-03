package com.mali.ds.dp.greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/* https://leetcode.com/problems/last-stone-weight/
 * easy*/
public class LastStoneWeight {

  /* we need to sort the weights each time after operation -->
   * priority queue does the job */
  public static int lastStoneWeight(int[] stones) {

    Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    for (int n : stones) {
      q.offer(n);
    }
    while (q.size() > 1) {
      int n1 = q.poll();
      int n2 = q.poll();
      q.offer(Math.abs(n1 - n2));
    }
    return q.poll();
  }

  public static void main(String[] args) {
    System.out.println(lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1}));
    System.out.println(lastStoneWeight(new int[] {1}));
  }
}
