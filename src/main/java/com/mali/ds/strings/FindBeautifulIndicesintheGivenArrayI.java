package com.mali.ds.strings;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-380/problems/find-beautiful-indices-in-the-given-array-i/ */
public class FindBeautifulIndicesintheGivenArrayI {

  public static List<Integer> beautifulIndices(String s, String a, String b, int k) {

    int aLen = a.length();
    int bLen = b.length();
    List<Integer> ans = new ArrayList();
    if (s.indexOf(a) == -1 || s.indexOf(b) == -1) return ans;
    TreeSet<Integer> set = new TreeSet<>();

    for (int i = 0; i < s.length(); i++) {
      int j = s.indexOf(b, i);
      if (j != -1) {
        set.add(j);
        i = j;
      } else {
        break;
      }
    }

    for (int i = 0; i < s.length(); i++) {
      int j = s.indexOf(a, i);
      if (j != -1) {
        if ((set.ceiling(j) != null && Math.abs(set.ceiling(j) - j) <= k)
            || (set.floor(j) != null && Math.abs(set.floor(j) - j) <= k)) {
          ans.add(j);
        }
        i = j;
      } else {
        break;
      }
    }
    return ans;
  }

  TreeSet<Integer> subStringKMP(String a, String s) {

    TreeSet<Integer> ans = new TreeSet<>();
    int[] aPrefix = prefix(a);


    return ans;
  }

  public static int[] prefix(String s) {
    final int len = s.length();
    final int[] ans = new int[len];
    for (int i = 1, j = 0; i < len; ) {
      if (s.charAt(i) == s.charAt(j)) {
        ans[i++] = ++j;
      } else {
        if (j > 0) {
          j = ans[j - 1];
        } else {
          i++;
        }
      }
    }
    return ans;
  }

  public static void main(final String[] args) {
    final String s = "isawsquirrelnearmysquirrelhouseohmy";
    final String a = "my";
    final String b = "squirrel";
    final int k = 15;
    beautifulIndices(s, a, b, k);
  }
}
