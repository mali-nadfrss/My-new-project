package com.mali.ds.dp.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/* https://leetcode.com/problems/two-city-scheduling/
 * medium */
public class TwoCityScheduling {
  public static int twoCitySchedCost(int[][] costs) {

    int ans = 0;
    Arrays.sort(costs, (o1, o2) -> (o1[0] - o1[1])-(o2[0] - o2[1]));
    for (int i = 0, j = costs.length-1; i < j; j--, i++) {
      ans += costs[i][0] + costs[j][1];
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(
        twoCitySchedCost(
            new int[][] {{515,563},{451,713},{537,709},{343,819},{855,779},{457,60},{650,359},{631,42}}));
  }
}
