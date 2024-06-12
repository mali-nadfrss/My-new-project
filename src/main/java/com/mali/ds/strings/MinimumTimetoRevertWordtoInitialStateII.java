package com.mali.ds.strings;

/* https://leetcode.com/problems/minimum-time-to-revert-word-to-initial-state-ii/description/ */
public class MinimumTimetoRevertWordtoInitialStateII {

  public static int minimumTimeToInitialState(String word, int k) {
    int ans = 1;
    int len = word.length();
    long[] sh = calHashStart(word);
    long[] eh = calHashEnd(word);
    for (int i = k; i < len; i = i + k) {

      if (sh[len - i - 1] == eh[i]) {
        System.out.println(ans);
        return ans;
      }
      ans++;
    }
    System.out.println(ans);
    return ans;
  }

  public static long[] calHashEnd(String s) {
    int len = s.length();
    long[] ans = new long[len];
    int m = 1000000009;

    for (int j = 0; j < len; j++) {
      int p = 31;
      long pp = 1;
      long hash = 0;
      for (int k = j; k < len; k++) {
        hash = (hash + s.charAt(k) - 'a' + 1) * pp % m;
        pp = (pp * p) % m;
      }
      ans[j] = hash;
    }

    return ans;
  }

  public static long[] calHashStart(String s) {
    int len = s.length();
    long[] ans = new long[len];
    int m = 1000000009;
    int p = 31;
    long pp = 1;
    long hash = 0;
    for (int k = 0; k < len; k++) {
      hash = (hash + s.charAt(k) - 'a' + 1) * pp % m;
      pp = (pp * p) % m;
      ans[k] = hash;
    }

    return ans;
  }

  public static void main(String[] args) {
    String word = "aba";
    int k = 1;
    minimumTimeToInitialState(word, k);
  }
}
