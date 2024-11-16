package com.mali.ds.graph.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class search2dArray {

  public static void search2dArr(char[][] grid, String word) {

    int r = grid.length;
    int c = grid[0].length;

    for (int i = 0; i < grid.length; i++) {

      for (int j = 0; j < grid[0].length; j++) {
        if (!found) {
          recursion(grid, word, 0, new LinkedList(), new boolean[r][c], i, j);
        }
      }
    }
  }

  static boolean found = false;
  static Queue<int[]> ans;

  static void recursion(
      char[][] grid, String word, int index, Queue<int[]> q, boolean[][] visited, int i, int j) {

    if (index >= word.length()) {
      found = true;
      ans = q;
      return;
    }

    if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
      return;
    }

    if (found) {
      return;
    }

    if (grid[i][j] == word.charAt(index) && !visited[i][j]) {
      visited[i][j] = true;
      q.add(new int[] {i, j});
      index = index+1;
      recursion(grid, word, index, q, visited, i + 1, j);
      recursion(grid, word, index, q, visited, i, j + 1);
      recursion(grid, word, index, q, visited, i - 1, j);
      recursion(grid, word, index, q, visited, i, j - 1);
    } else if(!q.isEmpty()){
      int[] rem = q.peek();
      if(rem[0] == i && rem[1] == j)
      q.poll();
    }
    visited[i][j] = false;
  }

  public static void main(String[] argv) {
    char[][] grid1 = {
      {'c', 'c', 't', 'n', 'a', 'x'},
      {'c', 'c', 'a', 't', 'n', 't'},
      {'a', 'c', 'n', 'n', 't', 't'},
      {'t', 'n', 'i', 'i', 'p', 'p'},
      {'a', 'o', 'o', 'o', 'a', 'a'},
      {'s', 'a', 'a', 'a', 'o', 'o'},
      {'k', 'a', 'i', 'o', 'k', 'i'}
    };
    String word1 = "catnip";
    String word2 = "cccc";
    String word3 = "s";
    String word4 = "ant";
    String word5 = "aoi";
    String word6 = "ki";
    String word7 = "aaoo";
    String word8 = "ooo";

    char[][] grid2 = {{'a'}};
    String word9 = "a";
    search2dArr(grid1, word1);
    while (ans != null && !ans.isEmpty()) {
      int[] pos = ans.poll();
      System.out.println("" + pos[0] + " , " + pos[1]);
    }
    ans = null;
    found = false;
    System.out.println("========================================================");
    search2dArr(grid1, word2);
    while (ans != null && !ans.isEmpty()) {
      int[] pos = ans.poll();
      System.out.println("" + pos[0] + " , " + pos[1]);
    }
    ans = null;
    found = false;
    System.out.println("========================================================");
    search2dArr(grid1, word3);
    while (ans != null && !ans.isEmpty()) {
      int[] pos = ans.poll();
      System.out.println("" + pos[0] + " , " + pos[1]);
    }
    ans = null;
    found = false;
    System.out.println("========================================================");
    search2dArr(grid1, word4);
    while (ans != null && !ans.isEmpty()) {
      int[] pos = ans.poll();
      System.out.println("" + pos[0] + " , " + pos[1]);
    }
    ans = null;
    found = false;
    System.out.println("========================================================");
    search2dArr(grid1, word5);
    while (ans != null && !ans.isEmpty()) {
      int[] pos = ans.poll();
      System.out.println("" + pos[0] + " , " + pos[1]);
    }
    ans = null;
    found = false;
    System.out.println("========================================================");
    search2dArr(grid1, word6);
    while (ans != null && !ans.isEmpty()) {
      int[] pos = ans.poll();
      System.out.println("" + pos[0] + " , " + pos[1]);
    }
    ans = null;
    found = false;
    System.out.println("========================================================");
  }
}
