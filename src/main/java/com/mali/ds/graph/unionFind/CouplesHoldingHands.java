package com.mali.ds.graph.unionFind;

/* https://leetcode.com/problems/couples-holding-hands/
 * Hard */
public class CouplesHoldingHands {

  //todo
  public int minSwapsCouples(int[] row) {
    int ans = 0;
    for (int i = 0; i < row.length; i++) {
      if ((row[i] % 2 == 0 && row[i + 1] == row[i] + 1)
          || (row[i] % 2 != 0 && row[i + 1] == row[i] - 1)) {
        i = i + 1;
      } else {
        ans++;
      }
    }
    return ans / 2;
  }
}
