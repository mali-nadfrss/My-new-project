package com.mali.ds.graph.bfs;

import java.util.*;

/* https://leetcode.com/problems/k-similar-strings/
 * Hard */
public class KSimilarStrings {

  // todo
  public static int kSimilarity(String s1, String s2) {
    int ans = 0;
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      map1.put(s1.charAt(i), i);
      map2.put(s2.charAt(i), i);
    }

    for (int i = 0; i < s1.length(); i++) {
      for (int j = map2.get(s1.charAt(i)); i != j; j = map2.get(s1.charAt(i))) {
        char c = s1.charAt(i);
        ans++;
      }
    }

    return ans;
  }

  static String swap(int i, int j, Map<Character, Integer> s) {

    return "";
  }

  public static void main(String[] args) {
    System.out.println(kSimilarity("abc", "bca"));
  }
}
