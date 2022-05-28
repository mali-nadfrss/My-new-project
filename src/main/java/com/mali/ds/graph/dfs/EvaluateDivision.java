package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* https://leetcode.com/problems/evaluate-division/
 * medium */
public class EvaluateDivision {

  public static double[] calcEquation(
      List<List<String>> equations, double[] values, List<List<String>> queries) {
    int n = values.length;
    double[] ans = new double[queries.size()];
    Map<String, Integer> map = new HashMap<>();
    double[][] grid = new double[2 * n][2 * n];
    int i = 0;
    for (int j = 0; j < equations.size(); j++) {
      String s1 = equations.get(j).get(0);
      String s2 = equations.get(j).get(1);
      int finalI1 = i;
      map.computeIfAbsent(s1, v -> finalI1);
      i += 1;
      int finalI = i;
      map.computeIfAbsent(s2, v -> finalI);
      i += 1;
      grid[map.get(s1)][map.get(s2)] = values[j];
      grid[map.get(s2)][map.get(s1)] = 1 / values[j];
    }

    for (int j = 0; j < queries.size(); j++) {
      String s1 = queries.get(j).get(0);
      String s2 = queries.get(j).get(1);
      if (map.get(s1) == null || map.get(s2) == null) {
        ans[j] = -1;
        continue;
      }
      double k = dfs(grid, map.get(s1), new boolean[2 * n], map.get(s2));
      ans[j] = k > 0 ? k : -1;
    }

    return ans;
  }

  static double dfs(double[][] grid, int start, boolean[] visited, int end) {
    if (start == end) {
      return 1;
    }
    visited[start] = true;
    for (int i = 0; i < grid[0].length; i++) {
      if (!visited[i] && grid[start][i] > 0) {
        double k = grid[start][i] * dfs(grid, i, visited, end);
        if (k > 0) return k;
      }
    }
    return -1;
  }

  public static void main(String[] args) {

    // {{"a","b"},{"b","c"}}, values = {2.0,3.0}, queries =
    // {{"a","c"},{"b","a"},{"a","e"},{"a","a"}}
    List<String> list1 = new ArrayList<>();
    list1.add("a");
    list1.add("b");

    List<String> list2 = new ArrayList<>();
    list2.add("b");
    list2.add("c");

    List<String> list3 = new ArrayList<>();
    list3.add("a");
    list3.add("c");

    List<String> list4 = new ArrayList<>();
    list4.add("b");
    list4.add("a");

    List<String> list5 = new ArrayList<>();
    list5.add("a");
    list5.add("e");

    List<String> list6 = new ArrayList<>();
    list6.add("a");
    list6.add("a");

    List<String> list7 = new ArrayList<>();
    list7.add("x");
    list7.add("x");

    List<List<String>> f1 = new ArrayList<>();
    f1.add(list1);
    f1.add(list2);

    List<List<String>> f2 = new ArrayList<>();
    f2.add(list3);
    f2.add(list4);
    f2.add(list5);
    f2.add(list6);
    f2.add(list7);

    System.out.println(calcEquation(f1, new double[] {2.0, 3.0}, f2));
  }
}
