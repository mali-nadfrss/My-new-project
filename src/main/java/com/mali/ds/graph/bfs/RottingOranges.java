package com.mali.ds.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/rotting-oranges/
 * medium */
public class RottingOranges {

  public static class Cell {
    int row;
    int column;

    Cell(int row, int column) {
      this.row = row;
      this.column = column;
    }
  }

  public static int orangesRotting(int[][] grid) {
    int ans = 0;
    int count = 0;
    Queue<Cell> q = new LinkedList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          count++;
        }
        if (grid[i][j] == 2) {
          q.add(new Cell(i, j));
        }
      }
    }
    if (count == 0) return 0;
    while (!q.isEmpty() && count > 0) {
      int m = q.size();
      for (int k = 0; k < m; k++) {
        Cell c = q.poll();
        int i = c.row;
        int j = c.column;
        if (i + 1 >= 0 && i + 1 < grid.length && grid[i + 1][j] == 1) {
          grid[i + 1][j] = 2;
          q.add(new Cell(i + 1, j));
          count--;
        }
        if (i - 1 >= 0 && i - 1 < grid.length && grid[i - 1][j] == 1) {
          grid[i - 1][j] = 2;
          q.add(new Cell(i - 1, j));
          count--;
        }
        if (j + 1 >= 0 && j + 1 < grid[0].length && grid[i][j + 1] == 1) {
          grid[i][j + 1] = 2;
          q.add(new Cell(i, j + 1));
          count--;
        }
        if (j - 1 >= 0 && j - 1 < grid[0].length && grid[i][j - 1] == 1) {
          grid[i][j - 1] = 2;
          q.add(new Cell(i, j - 1));
          count--;
        }
      }
      ans++;
    }

    if (count > 0) return -1;
    return ans;
  }

  public static void main(String[] args) {
    int[][] days = {{2,1,1},{1,1,1},{0,1,2}};

    System.out.println(orangesRotting(days));
  }
}
