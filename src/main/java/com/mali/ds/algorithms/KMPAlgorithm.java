package com.mali.ds.algorithms;

/*
https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 */
public class KMPAlgorithm {

  static void kmpSearch(String text, String pattern) {
    int patLen = pattern.length();
    int[] lps = computeLPS(pattern, patLen, new int[patLen]);
    int i = 0;
    int j = 0;
    while (i < text.length()) {
      if (pattern.charAt(j) == text.charAt(i)) {
        i++;
        j++;
        if (j == patLen) {
          j = lps[j - 1];
          System.out.println("pattern found at i: " + i + " from j: " + j);
        }
      } else {
        if (j > 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
  }

  // lps :longest proper prefix to a sufix
  static int[] computeLPS(String pattern, int m, int[] lps) {
    int len = 0;
    int i = 1;
    lps[0] = 0;

    while (i < m) {
      if (pattern.charAt(i) == pattern.charAt(len)) {
        lps[i++] = ++len;
      } else {
        if (len > 0) {
          len = lps[len - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }

  public static void main(String[] args) {
    String s = "AAAAABAAABA";
    String p = "AAAB";
    kmpSearch(s, p);
  }
}
