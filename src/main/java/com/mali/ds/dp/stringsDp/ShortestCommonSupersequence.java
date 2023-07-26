package com.mali.ds.dp.stringsDp;

import java.util.Arrays;

/* https://leetcode.com/problems/shortest-common-supersequence/ */
public class ShortestCommonSupersequence {

  public static String shortestCommonSupersequence(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();

    String[][] dp = new String[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      Arrays.fill(dp[i], "");
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
        } else {
          dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
        }
      }
    }

    String max = dp[m][n];
    int i = 0, j = 0;
    String ans = "";
    for (int k = 0; k < max.length(); i++, j++, k++) {

      while (i < m && str1.charAt(i) != max.charAt(k)) {
        ans += str1.charAt(i);
        i++;
      }
      while (j < n && str2.charAt(j) != max.charAt(k)) {
        ans += str2.charAt(j);
        j++;
      }
      ans += max.charAt(k);
    }

    return ans + str1.substring(i) + str2.substring(j);
  }

  public static void main(String[] args) {
    String str1 = "abac", str2 = "cab";
    shortestCommonSupersequence(str1, str2);
  }
}
