package com.mali.ds.strings;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* https://leetcode.com/problems/longest-nice-substring/
 * easy but imp*/
public class LongestNiceSubstring {
  public static int[] longestNiceSubstring(String R, int[] V) {

    int[] ans = new int[2];
    int[] arr = new int[2];
    ans[0] = 0;
    arr[0] = 0;
    ans[1] = 0;
    arr[1] = 0;

    for (int i = 1; i <R.length(); i++) {
      System.out.println("a "+R.substring(0,i));
      System.out.println("b "+R.substring(i,R.length()));
    }

    for (int i = 0; i < V.length; i++){
R.substring(0,i);
      if (R.charAt(i) == 'B'){
        arr[0] -= V[i];
        arr[1] += V[i];
        ans[0] = Math.min(ans[0], arr[0]);
      } else{
        arr[0] += V[i];
        arr[1] -= V[i];
        ans[1] = Math.min(ans[1], arr[1]);
      }

    }

    ans[0] = -1*ans[0];
    ans[1] = -1*ans[1];

    return ans;

    /*if (s.length() < 2) {
      return "";
    }

    String ans = "";

    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j <= s.length(); j++) {
        Set<Character> set = new HashSet<>();
        for (char c : s.substring(i, j).toCharArray()) {
          set.add(c);
        }
        String k = s.substring(i, j).toLowerCase();
        boolean flag = false;
        for (int l = 0; l < k.length(); l++) {
          if (!set.contains(k.charAt(l))) {
            flag = true;
            break;
          }
        }
        k = s.substring(i, j).toUpperCase(Locale.ROOT);
        for (int l = 0; l < k.length(); l++) {
          if (!set.contains(k.charAt(l))) {
            flag = true;
            break;
          }
        }
        if (!flag && k.length() > ans.length()) {
          ans = s.substring(i, j);
        }
      }
    }
    return ans;*/
  }

  public static void main(String[] args) {
    System.out.println(longestNiceSubstring("ayxbx", new int[]{10, 5, 10, 15}));
  }
}
