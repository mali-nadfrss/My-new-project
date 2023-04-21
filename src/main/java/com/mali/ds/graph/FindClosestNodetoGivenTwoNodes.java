package com.mali.ds.graph;

import java.util.Arrays;

/* https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/ */
public class FindClosestNodetoGivenTwoNodes {

  public static int closestMeetingNode(int[] edges, int node1, int node2) {

    int len = edges.length;
    int[] dist1 = new int[len];
    int[] dist2 = new int[len];

    Arrays.fill(dist1, -1);
    Arrays.fill(dist2, -1);
    int cur = node1;
    int prev = cur;
    while (cur != -1 && dist1[cur] == -1) {
      dist1[cur] = dist1[prev] + 1;
      prev = cur;
      cur = edges[cur];
    }

    cur = node2;
    prev = cur;
    while (cur != -1 && dist2[cur] == -1) {
      dist2[cur] = dist2[prev] + 1;
      prev = cur;
      cur = edges[cur];
    }

    int dist = Integer.MAX_VALUE;
    int ans = -1;
    for (int i = 0; i < len; i++) {

      if (dist1[i] != -1 && dist2[i] != -1) {
        int curDist = Math.max(dist1[i], dist2[i]);
        if (curDist < dist) {
          dist = curDist;
          ans = i;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] edges = {2, 2, 3, -1};
    int node1 = 0;
    int node2 = 1;
    closestMeetingNode(edges, node1, node2);
  }
}
