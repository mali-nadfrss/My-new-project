package com.mali.ds.Queues;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/contest/weekly-contest-336/problems/minimum-time-to-complete-all-tasks/ */
public class MinimumTimetoCompleteAllTasks {

  public static int findMinimumTime(int[][] tasks) {

    Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
    Set<Integer> usedTime = new HashSet<>();

    for (int[] task : tasks) {

      int dur = task[2];
      for (int start = task[0]; start <= task[1]; start++) {
        if (usedTime.contains(start)) {
          dur--;
        }
      }
      int end = task[1];
      while (dur > 0) {
        if (usedTime.add(end--)) {
          dur--;
        }
      }
    }
    return usedTime.size();
  }

  public static void main(String[] args) {

    int[][] in = {{1, 3, 2}, {2, 5, 3}, {5, 6, 2}};

    findMinimumTime(in);
  }
}
