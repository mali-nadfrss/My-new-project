package com.mali.ds.dp.decisionMaking;

import java.util.Arrays;
import java.util.TreeMap;

/* https://leetcode.com/problems/maximum-profit-in-job-scheduling/ */
public class MaximumProfitinJobScheduling {

  static class Job {

    int start;
    int end;
    int profit;
    int index;

    Job(int start, int end, int profit, int index) {

      this.start = start;
      this.end = end;
      this.profit = profit;
      this.index = index;
    }
  }

  public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

    int len = startTime.length;

    TreeMap<Integer, Job> map = new TreeMap<>();
    int[][] jobs = new int[len][3];

    for (int i = 0; i < len; i++) {
      jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
    }
    Arrays.sort(jobs, (j1, j2) -> j2[0] == j1[0] ? j2[2] - j1[2] : j1[0] - j2[0]);
    for (int i = 0; i < len; i++) {
      Job j = new Job(jobs[i][0], jobs[i][1], jobs[i][2], i);
      map.put(jobs[i][0], j);
    }

    return recursion(map, jobs, 0);
  }

  static int recursion(TreeMap<Integer, Job> map, int[][] jobs, int index) {

    if (index >= jobs.length) return 0;
    Job j =
        map.ceilingEntry(jobs[index][1]) != null
            ? map.ceilingEntry(jobs[index][1]).getValue()
            : null;
    int ans = 0;
    if (j != null) {
      // select the current job and go on
      ans = jobs[index][2] + recursion(map, jobs, j.index);
    }
    // dont select current one goto next one.
    return Math.max(ans, recursion(map, jobs, index + 1));
  }

  public static void main(String[] args) {

    int[] startTime = {1,2,3,4,6};
    int[] endTime = {3,5,10,6,9}, profit = {20,20,100,70,60};
    System.out.println(jobScheduling(startTime, endTime, profit));
  }
}
