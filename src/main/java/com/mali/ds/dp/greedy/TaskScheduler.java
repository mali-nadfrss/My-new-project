package com.mali.ds.dp.greedy;

/*  https://leetcode.com/problems/task-scheduler/
 * medium */

import java.util.Arrays;

public class TaskScheduler {

  public static int leastInterval(char[] tasks, int n) {
    if (n == 0) return tasks.length;
    int[] freq = new int[26];
    for (char c : tasks) {
      freq[c - 'A']++;
    }
    Arrays.sort(freq);
    int max = freq[25] - 1;
    int spaces = max * n;
    for (int i = 0; i <= 24; i++) {
      spaces = spaces - Math.min(max, freq[i]);
    }
    spaces = Math.max(0, spaces);
    return tasks.length + spaces;
  }

  public static void main(String[] args) {
    System.out.println(leastInterval(new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
  }
}
