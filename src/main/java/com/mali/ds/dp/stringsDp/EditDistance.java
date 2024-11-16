package com.mali.ds.dp.stringsDp;

/* https://leetcode.com/problems/edit-distance/
 * Hard
 * */
public class EditDistance {
  // tabulation is derived from recursion below
  public static int minDistance(String word1, String word2) {
    int m = word1.length() + 1;
    int n = word2.length() + 1;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m - 1; i++) {
      dp[i][n - 1] = m - i;
    }

    for (int i = 0; i < n - 1; i++) {
      dp[m - 1][i] = n - i;
    }

    for (int i = m - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        if (word1.charAt(i) == word2.charAt(j)) {
          dp[i][j] = dp[i + 1][j + 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
        }
      }
    }

    return dp[0][0];
  }

  static int recursion(String word1, String word2, int[][] dp, int i, int j) {
    if (i == word1.length()) {
      // if any word is empty we need the other word length
      return word2.length() - j;
    }
    if (j == word2.length()) {
      return word1.length() - i;
    }
    // dp needs word1 and word2 because word1 might get duplicated
    if (dp[i][j] != 0) {
      return dp[i][j];
    }
    if (word1.charAt(i) == word2.charAt(j)) {
      // if both chars are equal just check for next characters
      return dp[i][j] = recursion(word1, word2, dp, i + 1, j + 1);
    } else {
      // else condition, we have 3 options
      // delete the char in word1 as in below
      int ans1 = 1 + recursion(word1, word2, dp, i + 1, j);

      // replace the first character in word1 with that of word2 as in below
      int ans2 = 1 + recursion(word1, word2, dp, i + 1, j + 1);

      // insert a new character from word2 into word
      int ans3 = 1 + recursion(word1, word2, dp, i, j + 1);

      // return the minimum of all 3
      return dp[i][j] = Math.min(Math.min(ans1, ans2), ans3);
    }
  }

  public static void main(String[] args) {

    System.out.println(minDistance("intention", "execution"));
  }
}
