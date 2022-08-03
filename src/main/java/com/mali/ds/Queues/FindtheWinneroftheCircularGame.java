package com.mali.ds.Queues;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 * medium */
public class FindtheWinneroftheCircularGame {

  public static int findTheWinner(int n, int k) {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      q.add(i);
    }

    while (q.size() > 1) {
      int i = k - 1;
      while (i > 0) {
        q.offer(q.remove());
        i--;
      }
      q.remove();
    }
    return q.remove();
  }

  public static void main(String[] args) {
    System.out.println(findTheWinner(6, 5));
  }
}
