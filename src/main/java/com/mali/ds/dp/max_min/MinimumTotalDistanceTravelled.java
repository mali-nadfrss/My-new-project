package com.mali.ds.dp.max_min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* https://leetcode.com/problems/minimum-total-distance-traveled/discuss/2783305/Python-DP-Solution */
public class MinimumTotalDistanceTravelled {

  public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {

    Arrays.sort(factory, (a, b) -> a[0] - b[0]);
    Collections.sort(robot);

    return recursion(robot, factory, 0, 0, 0, new int[robot.size()][factory.length][robot.size()]);
  }

  static int recursion(
      List<Integer> robot,
      int[][] factory,
      int robotCount,
      int factCount,
      int remAtFactory,
      int[][][] dp) {

    if (robotCount >= robot.size()) {
      return 0;
    }
    if (factCount >= factory.length) {
      return Integer.MAX_VALUE;
    }
    if (dp[robotCount][factCount][remAtFactory] > 0) return dp[robotCount][factCount][remAtFactory];

    int ans1 = 0;
    if (factory[factCount][1] > remAtFactory) {
      int val = recursion(robot, factory, robotCount + 1, factCount, remAtFactory + 1, dp);
      if (val < Integer.MAX_VALUE) {
        ans1 += val + Math.abs(robot.get(robotCount) - factory[factCount][0]);
      }
    }

    int ans2 = recursion(robot, factory, robotCount, factCount + 1, 0, dp);
    return dp[robotCount][factCount][remAtFactory] = Math.min(ans1, ans2);
  }

  public static void main(String[] args) {

    List<Integer> robot = new ArrayList<>();
    robot.add(0);
    robot.add(4);
    robot.add(6);
    int[][] factory = {{2, 2}, {6, 2}};
    System.out.println(minimumTotalDistance(robot, factory));
  }
}
