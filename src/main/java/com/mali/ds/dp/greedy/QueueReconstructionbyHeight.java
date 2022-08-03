package com.mali.ds.dp.greedy;

/* https://leetcode.com/problems/queue-reconstruction-by-height/
 * medium
 * */

import java.util.ArrayList;
import java.util.Arrays;

public class QueueReconstructionbyHeight {

  public static int[][] reconstructQueue(int[][] people) {
    if (people == null || people.length == 0 || people[0].length == 0) return new int[0][0];

    Arrays.sort(
        people,
        (a, b) -> {
          if (b[0] == a[0]) return a[1] - b[1];
          return b[0] - a[0];
        });

    int n = people.length;
    ArrayList<int[]> tmp = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      tmp.add(people[i][1], new int[] {people[i][0], people[i][1]});
    }

    int[][] res = new int[people.length][2];
    int i = 0;
    for (int[] k : tmp) {
      res[i][0] = k[0];
      res[i++][1] = k[1];
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(
        reconstructQueue(new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}));
  }
}
