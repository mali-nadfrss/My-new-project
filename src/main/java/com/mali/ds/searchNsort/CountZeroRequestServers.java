package com.mali.ds.searchNsort;

import java.util.*;

/* https://leetcode.com/contest/biweekly-contest-107/problems/count-zero-request-servers/ */
public class CountZeroRequestServers {

  public static int[] countServers(int n, int[][] logs, int x, int[] queries) {

    int qlen = queries.length;
    int[] ans = new int[qlen];
    Arrays.fill(ans, n);
    int[] tq = Arrays.copyOf(queries, qlen);
    Arrays.sort(tq);
    Arrays.sort(logs, Comparator.comparingInt(o -> o[1]));
    int start = 0;
    int i = 0;
    Set<Integer> set = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int j = 0; j < qlen; j++) {
      while ( start <logs.length && logs[start][1] < tq[j] - x) {
        set.remove(logs[start][0]);
        start++;
      }
      i = start;
      while (i < logs.length && logs[i][1] <= tq[j]) {
        set.add(logs[i][0]);
        i++;
      }
      map.put(tq[j], set.size());
    }
    for (int j = 0; j < qlen; j++) {
      ans[j] -= map.get(queries[j]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] logs = {{1, 21}};
    int x = 10;
    int[] queries = {24, 35, 28, 26, 20, 25, 16, 31, 12};
    System.out.println(countServers(n, logs, x, queries));
  }
}
