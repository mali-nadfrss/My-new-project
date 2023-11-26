package com.mali.ds.strings;

/*
 * https://leetcode.com/problems/apply-operations-to-make-two-strings-equal/description/
 * */
public class ApplyOperationstoMakeTwoStringsEqual {

  public static int minOperations(int[] s1, int[] s2, int x, int index) {
    int len = s1.length;
    int ans = Integer.MAX_VALUE;
    if (index == len - 1) {
      if (s1[index] == s2[index]) return 0;
      return Integer.MAX_VALUE;
    }

    if (s1[index] == s2[index]) {
      return minOperations(s1, s2, x, index + 1);
    }

    if (s1[index] != s1[index + 1]) {
      s1[index] = s1[index] == 1 ? 0 : 1;
      s1[index + 1] = s1[index + 1] == 1 ? 0 : 1;
      ans = 1 + minOperations(s1, s2, x, index + 1);
      s1[index] = s1[index] == 1 ? 0 : 1;
      s1[index + 1] = s1[index + 1] == 1 ? 0 : 1;
    }
    for (int i = index + 2; i < index; i++) {
      s1[index] = s1[index] == 1 ? 0 : 1;
      s1[i] = s1[i] == 1 ? 0 : 1;
      ans = Math.min(ans, x + minOperations(s1, s2, x, index + 1));
      s1[index] = s1[index] == 1 ? 0 : 1;
      s1[i] = s1[i] == 1 ? 0 : 1;
    }

    return ans;
  }

  public static void main(String[] args) {

    System.out.println(
        minOperations(
            new int[] {1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
            new int[] {0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
            2,
            0));
  }
}
