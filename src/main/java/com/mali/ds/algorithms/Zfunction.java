package com.mali.ds.algorithms;

/*https://www.geeksforgeeks.org/z-algorithm-linear-time-pattern-searching-algorithm/
https://personal.utdallas.edu/~besp/demo/John2010/z-algorithm.htm
*/
public class Zfunction {

  public static String lps(String s) {
    int len = s.length();
    int l, r, i;
    int[] z = new int[len];

    String ans = "";

    for (i = 1; i < len; i++) {
      l = r = i;
      while (r < len && s.charAt(r) == s.charAt(r - l)) r++;
      if (r - l > ans.length()) {
        ans = s.substring(l, r + 1);
      }

      while (i < r) {
        z[i++] = r - l++;
      }
      i--;
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "ababab";
    System.out.println(lps(s));
  }
}
