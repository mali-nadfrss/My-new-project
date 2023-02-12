package com.mali.ds.graph.dfs;

import java.util.*;

/* https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum/description/ */
public class DifferenceBetweenMaximumandMinimumPriceSum {

  public static long maxOutput(int n, int[][] edges, int[] price) {



    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] i : edges) {
      graph.putIfAbsent(i[0], new ArrayList<>());
      graph.putIfAbsent(i[1], new ArrayList<>());
      graph.get(i[0]).add(i[1]);
      graph.get(i[1]).add(i[0]);
    }


    long[] max1 = new long[n];
    ans = dfs1(0, graph, -1, price, max1);
     dfs2(0, graph, max1, -1, 0, price);
     return ans;
  }
  static long ans = 0;
  static long dfs1(
      int startNode, Map<Integer, List<Integer>> map, int parent, int[] price, long[] max1) {

    long max = 0;
    if (map.get(startNode).size() == 0) {
      max1[startNode] = price[startNode];
      return price[startNode];
    }
    for (int i : map.get(startNode)) {
      if (i != parent) {
        max = Math.max(max, dfs1(i, map, startNode, price, max1));
      }
    }
    max1[startNode] = max;
    return max;
  }

  static void dfs2(int start, Map<Integer, List<Integer>> map, long[] max1, int parent, long parent_cont, int[] price) {

    long c1=0, c2 = 0;
    int cn;
    for (int i : map.get(start)) {
        if (i == parent){
          continue;
        }

        if(max1[i] > c1){
          cn = 1;
          c2 = c1;
          c1 = max1[i];
        } else if(max1[i] > c2){
          c2 = max1[i];
        }

    }

    ans = Math.max(ans,price[start]+ Math.max(c1, parent_cont));

    for (int i  : map.get(start)) {

    }


  }

  public static void main(String[] args) {
    int n = 6;
    int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {3, 5}};
    int[] price = {9, 8, 7, 6, 10, 5};
    System.out.println(maxOutput(n, edges, price));
  }
}
