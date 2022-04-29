package com.mali.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* https://leetcode.com/problems/course-schedule/
 * medium */
public class CourseSchedule {

  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] finalans = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      finalans[i] = numCourses - i - 1;
    }
    if (prerequisites.length == 0) {
      return finalans;
    }
    ans = new ArrayList<>();
    canFinish(numCourses, prerequisites);
    if (ans == null) {
      return new int[] {};
    }
    for (int i = ans.size() - 1, j = 0; i >= 0; j++, i--) {
      finalans[j] = ans.get(i);
    }
    return finalans;
  }

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, LinkedList<Integer>> hashMap = new HashMap<>();

    for (int[] i : prerequisites) {
      hashMap.computeIfAbsent(i[1], v -> new LinkedList<>());
      hashMap.get(i[1]).add(i[0]);
    }
    boolean[] visited = new boolean[numCourses + 1];
    boolean[] dp = new boolean[numCourses + 1];
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(hashMap, visited, i, dp)) {
        ans = null;
        return false;
      }
    }
    return true;
  }

  static ArrayList<Integer> ans = new ArrayList<>();

  static boolean dfs(
      HashMap<Integer, LinkedList<Integer>> hashMap, boolean[] visited, int i, boolean[] dp) {
    if (visited[i]) {
      return dp[i];
    }
    if (!visited[i]) {
      visited[i] = true;
      LinkedList<Integer> list = hashMap.get(i);
      if (list != null) {
        for (int j : list) {
          if (!dfs(hashMap, visited, j, dp)) {
            dp[i] = false;
            ans = null;
            return false;
          }
        }
      }
      ans.add(i);
      dp[i] = true;
      return true;
    }
    ans = null;
    return false;
  }

  public static void main(String[] args) {
    int[][] days = {{1, 0}};
    System.out.println(findOrder(3, days));
  }
}
