package com.mali.ds.bitManipulation;

/* https://leetcode.com/contest/weekly-contest-329/problems/apply-bitwise-operations-to-make-strings-equal/ */
public class ApplyBitwiseOperationstoMakeStringsEqual {

  public static boolean makeStringsEqual(String s, String target) {

    if (s.equals(target)) return true;

    int len = s.length();
    int count1 = 0;
    int count0 = 0;
    for (char c : s.toCharArray()) {

      if (c == '0') {
        count0++;
      } else {
        count1++;
      }
    }

    if (count1 == len || count0 == len) return false;

    int i = 0, j = 1;
    char[] s1 = s.toCharArray();
    char[] t1 = target.toCharArray();

    return true;
  }

  public static void main(String[] args) {
    System.out.println(makeStringsEqual("00011",
            "01010"));
  }
}
