package com.mali.ds.searchNsort;

import java.util.Arrays;
import java.util.TreeMap;

/* https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/description/ */
public class MaximumNumberofTasksYouCanAssign {

  public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
    Arrays.sort(workers);
    TreeMap<Integer, Integer> taskMap = new TreeMap<>();
    for (int i : tasks) {
      taskMap.put(i, taskMap.getOrDefault(i, 0) + 1);
    }
    int ans = 0;

    for (int i = workers.length - 1; i >= 0; i--) {
      if (taskMap.floorKey(workers[i]) != null) {
        ans++;
        int task = taskMap.floorKey(workers[i]);
        if (taskMap.get(task) == 1) {
          taskMap.remove(task);
        } else {
          taskMap.put(task, taskMap.get(task) - 1);
        }
      } else if (pills > 0 && taskMap.floorKey(workers[i] + strength) != null) {
        pills--;
        ans++;
        int task = taskMap.floorKey(workers[i] + strength);
        if (taskMap.get(task) == 1) {
          taskMap.remove(task);
        } else {
          taskMap.put(task, taskMap.get(task) - 1);
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] tasks = {10, 15, 30};
    int[] workers = {0, 10, 10, 10, 10};
    int pills = 3;
    int strength = 10;
    maxTaskAssign(tasks, workers, pills, strength);
  }
}
