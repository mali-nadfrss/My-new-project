package com.mali.ds.strings;

public class Multiplication {

  /* s1 s2 are strings multiply them */
  public String multiplyStrings(String s1, String s2) {
    // code here.
    String ans = "";
    if (s1.equals("0") || s2.equals("0")) {
      return "0";
    }
    int l = s1.length();
    int k = s2.length();
    int carry = 0;
    String temp = "";
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < k; j++) {
        int value =
            Integer.parseInt(String.valueOf(s1.charAt(i)))
                * Integer.parseInt(String.valueOf(s1.charAt(j)));
        carry = value / 10;
        ans = value + ans;
      }
    }
    return ans;
  }
}
