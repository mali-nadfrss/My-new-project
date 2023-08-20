package com.mali.ds.graph;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-357/problems/find-the-safest-path-in-a-grid/ */
public class FindTheSafestPathInaGrid {

  public static int maximumSafenessFactor(List<List<Integer>> grid) {

    TreeSet<Integer> set = new TreeSet<>();
    set.add(12);
    set.floor(10);
    Queue<int[]> thiefs = new LinkedList<>();
    int n = grid.size();
    int[][] sg = new int[n][n];
    int[][] vis = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid.get(i).get(j) == 1) {
          thiefs.add(new int[] {i, j});
          vis[i][j] = 1;
          sg[i][j] = 0;
        }
      }
    }

    int max = Integer.MAX_VALUE;
    int dist = 0;
    while (!thiefs.isEmpty()) {
      int s = thiefs.size();
      for (int i = 0; i < s; i++) {
        int[] arr = thiefs.poll();
        sg[arr[0]][arr[1]] = dist;
        for (int[] ints : dir) {
          int x = arr[0] + ints[0];
          int y = arr[1] + ints[1];
          if (x >= 0 && y >= 0 && y < n && x < n && vis[x][y] == 0) {
            vis[x][y] = 1;
            thiefs.add(new int[] {x, y});
          }
        }
      }
      ++dist;
    }

    if (sg[0][0] == 0 || sg[n - 1][n - 1] == 0) return 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -sg[a[0]][a[1]]));
    pq.add(new int[] {0, 0});
    vis = new int[n][n];
    vis[0][0] = 1;
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int x = cur[0];
      int y = cur[1];
      max = Math.min(max, sg[x][y]);
      if (x == n - 1 && y == n - 1) break;
      for (int[] arr : dir) {
        int a = x + arr[0];
        int b = y + arr[1];
        if (a >= 0 && a < n && b >= 0 && b < n && vis[a][b] == 0) {
          vis[a][b] = 1;
          pq.add(new int[] {a, b});
        }
      }
    }

    return max;
  }

  static final int[][] dir1 = {
    {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
  };
  static final int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

  public static void main(String[] args) {

    int[][] arr = {{0, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}};
    int n = arr.length;
    List<List<Integer>> grid = new ArrayList<>();
    for (int[] ints : arr) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        list.add(ints[j]);
      }
      grid.add(list);
    }
    System.out.println(maximumSafenessFactor(grid));
  }
}
