package com.mali.ds.dp.mergingIntervals;

/* https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 * medium
 *  */
public class MinimumScoreTriangulationofPolygon {

  /* idea is to take 1 side as fixed side and move the edge to all possible corners and find
   * the minimum result
   *  */
  public static int minScoreTriangulation(int[] values) {
    return recursion(0, values.length - 1, 1, values);
  }

  //todo
  static int recursion(int i, int j, int k, int[] values) {
    if (i < 0
        || j < 0
        || k < 0
        || i == k
        || i == j
        || i > values.length
        || j > values.length) {
      return 0;
    }
    int ans = Integer.MAX_VALUE;
    for (int l = k; l < j; l++) {
      ans =
          Integer.min(
              ans,
              values[i] * values[j] * values[k]
                  + recursion(i, k, k - 1, values)
                  + recursion(j, k, k + 1, values));
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(minScoreTriangulation(new int[] {3, 7, 4, 5}));
  }
}
