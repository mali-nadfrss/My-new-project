package com.mali.ds.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * medium */
public class ShortestPathInBinaryMatrix {
  static int n;

  // we shouldnt go for dp as we might need to traverse in 1 path more than once
  // usually in dp we need to cover only side and down but here we need to cover all 8 possibilities
  // use bfs or djikstra's algo to find the shortest path
  public static int shortestPathBinaryMatrix(int[][] grid) {
    n = grid.length;
    if (grid[n - 1][n - 1] == 1 || grid[0][0] == 1) return -1;
    return bfs(grid);
  }

  public static int bfs(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {0, 0, 0});
    grid[0][0] = 1;
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      if (cell[0] == n - 1 && cell[1] == n - 1) {
        return cell[2] + 1;
      }
      for (int[] d : dir) {
        if (cell[0] + d[0] >= 0
            && cell[1] + d[1] >= 0
            && cell[0] + d[0] < n
            && cell[1] + d[1] < n
            && grid[cell[0] + d[0]][cell[1] + d[1]] != 1) {
          queue.add(new int[] {cell[0] + d[0], cell[1] + d[1], cell[2] + 1});
          grid[cell[0] + d[0]][cell[1] + d[1]] = 1;
        }
      }
    }
    return -1;
  }

  static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

  public static void main(String[] args) {
    int[][] days = {{1,0,0},{0,0,0},{0,0,0}};
    int[][] days2 = {
      {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
      {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
      {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
      {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
      {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
      {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
      {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
      {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
      {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
    };
    System.out.println(shortestPathBinaryMatrix(days));
    System.out.println(shortestPathBinaryMatrix(days2));
  }
}
