package com.mali.ds.strings;

/* https://leetcode.com/problems/subsequence-with-the-minimum-score/description/ */
public class SubsequenceWiththeMinimumScore {

  public static int minimumScore(String s, String t) {

    int[] l1 = new int[t.length()];
    int[] l2 = new int[t.length()];

    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t.charAt(j)) {
        l1[j++] = i;
      }
      if (j == t.length()) return 0;
    }

    while (j < t.length()) {
      l1[j++] = s.length();
    }
    j = t.length() - 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == t.charAt(j)) {
        l2[j--] = i;
      }
    }

    if (j == t.length() - 1) return t.length();

    while (j >= 0) {
      l2[j--] = -1;
    }

    int ans = Integer.MAX_VALUE;
    j = 0;
    for (int i = 0; i < t.length(); i++) {
      int start = 0;
      int end = t.length();
      while (start < end) {
        int mid = start + (end - start) / 2;
        if (l1[i] < l2[mid]) {
          end = mid;
          ans = Math.min(ans, mid - i - 1);
        } else {
          start = mid + 1;
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(minimumScore("eeecaeecdeeadcdbcaa", "edecabe"));
  }
}
