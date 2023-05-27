package com.mali.ds.maths;

/* https://leetcode.com/contest/weekly-contest-346/problems/find-the-punishment-number-of-an-integer/ */
public class FindthePunishmentNumberofanInteger {

  static int[] val = new int[1001];

  static {
    for (int i = 1; i <= 1000; i++) {
      if (isPartition(i)) {
        val[i] = val[i - 1] + i * i;
      } else {
        val[i] = val[i - 1];
      }
    }
  }

  public static int punishmentNumber(int n) {
    return val[n];
  }

  static boolean isPartition(int i) {
    long sq = i * i;
    StringBuilder sb = new StringBuilder(Long.toString(sq));
    return isPossible(sb, 0, i);
  }

  static boolean isPossible(StringBuilder s, int i, int val) {
    if(val < 0 ) return false;
    if (val == 0 && i == s.length()) return true;
    for (int j = 1; i+j <= s.length(); j++) {
      String str = s.substring( i, i+j);
      //if(str.equals("")) break;
      int k = Integer.parseInt(s.substring( i, i+j));
      if (isPossible(s, i + j, val - k)) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(punishmentNumber(36));
  }
}
