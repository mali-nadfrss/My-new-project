package com.mali.ds.dp.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* https://www.geeksforgeeks.org/water-connection-problem/ */
public class WaterConnectionProblem {

  static ArrayList<ArrayList<Integer>> solve(
      int n, int p, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> d) {
    // code here

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    Map<Integer, int[]> map = new HashMap<>();
    int[] indegree = new int[n + 1];

    for (int i = 0; i < p; i++) {
      map.put(a.get(i), new int[] {a.get(i), b.get(i), d.get(i)});
      indegree[b.get(i)]++;
    }

    for (int i = 1; i <= n; i++) {

      if (indegree[i] == 0 && map.get(i) != null) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(i);
        ans.add(temp);
        calculate(temp, map.get(i)[2], map.get(i)[1], map);
      }
    }
    return ans;
  }

  static void calculate(ArrayList<Integer> temp, int min, int index, Map<Integer, int[]> map) {
    if (map.get(index) == null) {
      temp.add(index);
      temp.add(min);
      return;
    }
    min = Math.min(map.get(index)[2], min);
    calculate(temp, min, map.get(index)[1], map);
  }

  public static void main(String[] args) {
    int n = 17, p = 11;
    int a[] = {6, 4, 14, 17, 3, 15, 16, 5, 7, 11, 12};
    int b[] = {5, 7, 16, 12, 2, 13, 6, 17, 1, 4, 8};
    int d[] = {2, 2, 2, 4, 8, 2, 8, 8, 9, 9, 2};

    ArrayList<Integer> al = new ArrayList<>();
    for (int i : a) {
      al.add(i);
    }

    ArrayList<Integer> bl = new ArrayList<>();
    for (int i : b) {
      bl.add(i);
    }

    ArrayList<Integer> dl = new ArrayList<>();
    for (int i : d) {
      dl.add(i);
    }
    solve(n, p, al, bl, dl);
  }
}
