package com.mali.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Arc {

  static class Worker {
    int quality;
    int wage;
    double ratio;

    Worker(int quality, int wage) {
      this.quality = quality;
      this.wage = wage;
      this.ratio = (double) wage / quality;
    }
  }

  static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    int len = quality.length;
    Worker[] workers = new Worker[len];
    for (int i = 0; i < len; i++) {
      Worker w = new Worker(quality[i], wage[i]);
      workers[i] = w;
    }

    Arrays.sort(workers, (a, b) -> Double.compare(b.ratio, a.ratio));
    PriorityQueue<Worker> pq = new PriorityQueue<>((a, b) -> b.quality - a.quality);

    int totalSum = 0;
    double ans = Integer.MAX_VALUE;
    for (int i = 0; i < len; i++) {
      pq.add(workers[i]);
      totalSum += workers[i].quality;
      if (pq.size() > k) {
        Worker w = pq.poll();
        totalSum -= w.quality;
      }
      if (pq.size() == k) {
        double temp = totalSum * pq.peek().ratio;
        ans = Math.min(ans, temp);
      }
    }
    return ans;
  }

  public static void main(String[] args) {

    int[] quality = {10, 20, 5};
    int[] wage = {70, 50, 30};
    int k = 2;
    // r  = w/q
    System.out.println(mincostToHireWorkers(quality, wage, k));
  }
}
