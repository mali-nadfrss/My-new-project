package com.mali.ds.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/* https://leetcode.com/contest/weekly-contest-310/problems/divide-intervals-into-minimum-number-of-groups/ */
public class divideintervalsintominimumnumberofgroups {

  public static int minGroups(int[][] intervals) {

    Arrays.sort(
        intervals,
        (o1, o2) -> {
          if (o1[0] == o1[1]) {
            return o1[1] - o2[1];
          }
          return o1[0] - o2[0];
        });

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < intervals.length; i++) {

      if (!pq.isEmpty() && pq.peek() < intervals[i][0]) {
        pq.poll();
      }
      pq.add(intervals[i][1]);
    }

    return pq.size();
  }

  public static void main(String[] args) {

    int[][] A = {
      {441, 446}, {801, 840}, {871, 963}, {228, 336}, {807, 946}, {479, 507}, {693, 944}, {751, 821}
    };
    System.out.println(minGroups(A));
  }
}
