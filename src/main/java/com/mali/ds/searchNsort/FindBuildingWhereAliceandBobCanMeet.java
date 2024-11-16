package com.mali.ds.searchNsort;

import java.util.Arrays;
import java.util.Stack;

/* https://leetcode.com/contest/weekly-contest-372/problems/find-building-where-alice-and-bob-can-meet/
 * Hard
 * */
public class FindBuildingWhereAliceandBobCanMeet {

  static class Tuple {
    int index;
    int height;

    Tuple(int index, int height) {
      this.index = index;
      this.height = height;
    }
  }

  public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {

    int hLen = heights.length;
    // using mono stack and preprocessing the queries.
    int qLen = queries.length;
    int[] ans = new int[queries.length];
    int[] nextIndex = new int[hLen];
    Arrays.fill(nextIndex, -1);
    Stack<Tuple> stack = new Stack<>();
    for (int i = 0; i < hLen; i++) {
      while (!stack.isEmpty() && heights[i] >= stack.peek().height) {
        nextIndex[stack.pop().index] = i;
      }
      stack.add(new Tuple(i, heights[i]));
    }

    for (int i = 0; i < qLen; i++) {
      int q1 = Math.max(queries[i][0], queries[i][1]);
      int q2 = Math.min(queries[i][0], queries[i][1]);
      if (heights[q1] >= heights[q2]) {
        ans[i] = q1;
        continue;
      }

      while (q1 != -1 && heights[q1] < heights[q2]) {
        q1 = nextIndex[q1];
      }
      ans[i] = nextIndex[q1];
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] heights = {3, 2, 1};

    // 0, 0, 2, 3
    // 2, 0, 0, 3
    int[][] queries = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

    leftmostBuildingQueries(heights, queries);
  }
}
