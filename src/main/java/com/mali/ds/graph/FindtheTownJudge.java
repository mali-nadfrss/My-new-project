package com.mali.ds.graph;

/* https://leetcode.com/problems/find-the-town-judge/
 * easy */
public class FindtheTownJudge {
  public static int findJudge(int n, int[][] trust) {
    int[] parent = new int[n + 1];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < trust.length; i++) {
      parent[trust[i][0]] = trust[i][1];
    }

    int ans = parent[1];
    for (int i = 1; i < parent.length; i++) {
      if (ans != parent[i] || ans != find(parent, i)) {
        return -1;
      }
    }
    return ans;
  }

  static int find(int[] parent, int i) {
    if (parent[i] != i) {
      parent[i] = find(parent, parent[i]);
    }
    return parent[i];
  }

  public static void main(String[] args) {
    int[][] days =  {{1,3},{2,3},{3,1}};

    System.out.println(findJudge(3, days));
  }
}
