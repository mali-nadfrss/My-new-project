package com.mali.ds.graph.dfs;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/* https://leetcode.com/contest/weekly-contest-323/problems/maximum-number-of-points-from-grid-queries/ */
public class MaximumNumberofPointsFromGridQueries {

  static int ans = 0;

  public static void maxPoints(int[][] grid, int queries, boolean[][] visited, int i, int j) {

    ans++;
    visited[i][j] = true;
    if (i + 1 < grid.length && grid[i + 1][j] < queries && !visited[i + 1][j]) {
      maxPoints(grid, queries, visited, i + 1, j);
    }
    if (j + 1 < grid[0].length && grid[i][j + 1] < queries && !visited[i][j + 1]) {
      maxPoints(grid, queries, visited, i, j + 1);
    }
    if (i - 1 >= 0 && grid[i - 1][j] < queries && !visited[i - 1][j]) {
      maxPoints(grid, queries, visited, i - 1, j);
    }
    if (j - 1 >= 0 && grid[i][j - 1] < queries && !visited[i][j - 1]) {
      maxPoints(grid, queries, visited, i, j - 1);
    }
  }

  public static int[] maxPoints(int[][] grid, int[] queries) {
    int[] fans = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      ans = 0;
      boolean[][] visited = new boolean[grid.length][grid[0].length];
      if (queries[i] > grid[0][0]) maxPoints(grid, queries[i], visited, 0, 0);
      fans[i] = ans;
    }
    return fans;
  }

  // better implementation
  public static int[] maxPointsActual(int[][] grid, int[] queries) {
    int[] fans = new int[queries.length];
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.add(new int[] {grid[0][0], 0, 0});
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int max = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    visited[0][0] = true;
    while (!pq.isEmpty()) {
      int[] arr = pq.poll();
      map.put(max, map.getOrDefault(max, 0) + 1);
      max = Math.max(arr[0], max);
      grid[arr[1]][arr[2]] = max;

      if (arr[1] + 1 < grid.length && !visited[arr[1]][arr[2]]) {
        visited[arr[1] + 1][arr[2]] = true;
        pq.add(new int[] {grid[arr[1] + 1][arr[2]], arr[1] + 1, arr[2]});
      }
      if (arr[1] - 1 >= 0 && !visited[arr[1] - 1][arr[2]]) {
        visited[arr[1] - 1][arr[2]] = true;
        pq.add(new int[] {grid[arr[1] - 1][arr[2]], arr[1] - 1, arr[2]});
      }
      if (arr[2] + 1 < grid[0].length && !visited[arr[1]][arr[2] + 1]) {
        visited[arr[1]][arr[2] + 1] = true;
        pq.add(new int[] {grid[arr[1]][arr[2] + 1], arr[1], arr[2] + 1});
      }
      if (arr[2] - 1 >= 0 && !visited[arr[1]][arr[2] - 1]) {
        visited[arr[1]][arr[2] - 1] = true;
        pq.add(new int[] {grid[arr[1]][arr[2] - 1], arr[1], arr[2] - 1});
      }
    }

    TreeMap<Integer, Integer> tree = new TreeMap<>();
    int prev = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      prev += entry.getValue();
      tree.put(entry.getKey(), prev);
    }

    for (int i = 0; i < queries.length; i++) {
      fans[i] = tree.floorKey(queries[i]) != null ? tree.get(tree.floorKey(queries[i])) : 0;
    }

    return fans;
  }

  public static void main(String[] args) {
    int[][] grid = {
      {
        249472, 735471, 144880, 992181, 760916, 920551, 898524, 37043, 422852, 194509, 714395,
        325171
      },
      {
        295872, 922051, 900801, 634980, 644237, 912433, 857189, 98466, 725226, 984534, 370121,
        399006
      },
      {
        618420, 573065, 587011, 298153, 694872, 12760, 880413, 593508, 474772, 291113, 852444, 77998
      },
      {
        67650, 426517, 146447, 190319, 379151, 184754, 479219, 106819, 138473, 865661, 799297,
        228827
      },
      {390392, 789371, 772048, 730506, 7144, 862164, 650590, 21524, 879440, 396198, 408897, 851020},
      {
        932044, 662093, 436861, 246956, 128943, 167432, 267483, 148325, 458128, 418348, 900594,
        831373
      },
      {
        742255, 795191, 598857, 441846, 243888, 777685, 313717, 560586, 257220, 488025, 846817,
        554722
      },
      {
        252507, 621902, 87704, 599753, 651175, 305330, 620166, 631193, 385405, 183376, 432598,
        706692
      },
      {
        984416, 996917, 586571, 324595, 784565, 300514, 101313, 685863, 703194, 729430, 732044,
        349877
      },
      {
        155629, 290992, 539879, 173659, 989930, 373725, 701670, 992137, 893024, 455455, 454886,
        559081
      },
      {
        252809, 641084, 632837, 764260, 68790, 732601, 349257, 208701, 613650, 429049, 983008, 76324
      },
      {
        918085, 126894, 909148, 194638, 915416, 225708, 184408, 462852, 40392, 964501, 436864,
        785076
      },
      {
        875475, 442333, 111818, 494972, 486734, 901577, 46210, 326422, 603800, 176902, 315208,
        225178
      },
      {
        171174, 458473, 744971, 872087, 680060, 95371, 806370, 322605, 349331, 736473, 306720,
        556064
      },
      {207705, 587869, 129465, 543368, 840821, 977451, 399877, 486877, 327390, 8865, 605705, 481076}
    };
    int[] queries = {690474, 796832, 913701, 939418, 46696, 266869, 150594, 948153, 718874};

    System.out.println(maxPoints(grid, queries));
    System.out.println(maxPointsActual(grid, queries));
  }
}
