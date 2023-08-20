package com.mali.ds.strings;

/* https://leetcode.com/problems/longest-nice-substring/
 * easy but imp*/
public class LongestNiceSubstring {
  public static int[] longestNiceSubstring(String R, int[] V) {

    int[] ans = new int[2];
    int[] arr = new int[2];

    for (int i = 1; i < R.length(); i++) {
      System.out.println("a " + R.substring(0, i));
      System.out.println("b " + R.substring(i));
    }

    for (int i = 0; i < V.length; i++) {
      R.substring(0, i);
      if (R.charAt(i) == 'B') {
        arr[0] -= V[i];
        arr[1] += V[i];
        ans[0] = Math.min(ans[0], arr[0]);
      } else {
        arr[0] += V[i];
        arr[1] -= V[i];
        ans[1] = Math.min(ans[1], arr[1]);
      }
    }
    ans[0] = -1 * ans[0];
    ans[1] = -1 * ans[1];

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(longestNiceSubstring("ayxbx", new int[] {10, 5, 10, 15}));
  }
}
