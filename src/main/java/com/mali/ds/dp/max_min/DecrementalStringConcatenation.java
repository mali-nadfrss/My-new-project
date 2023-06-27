package com.mali.ds.dp.max_min;

/* https://leetcode.com/problems/decremental-string-concatenation/description/ */
public class DecrementalStringConcatenation {

  public int minimizeConcatenatedLength(String[] words) {
    String word = words[0];
    int len = word.length();
    int[][][] dp = new int[words.length][26][26];
    return recursion(1, words, word.charAt(0), word.charAt(len - 1), dp) + len;
  }

  int recursion(int i, String[] words, char f, char l, int[][][] dp) {
    if (i >= words.length) return 0;
    if (dp[i][f - 'a'][l - 'a'] > 0) return dp[i][f - 'a'][l - 'a'];
    String word = words[i];
    int len = word.length();
    int first = 0;
    int last = 0;
    if (word.charAt(0) == l) {
      first = recursion(i + 1, words, f, word.charAt(len - 1), dp) + len - 1;
    } else {
      first = recursion(i + 1, words, f, word.charAt(len - 1), dp) + len;
    }
    if (word.charAt(len - 1) == f) {
      last = recursion(i + 1, words, word.charAt(0), l, dp) + len - 1;
    } else {
      last = recursion(i + 1, words, word.charAt(0), l, dp) + len;
    }
    return dp[i][f - 'a'][l - 'a'] = Math.min(first, last);
  }
}
