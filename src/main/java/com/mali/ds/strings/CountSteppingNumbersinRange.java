package com.mali.ds.strings;

/* https://leetcode.com/contest/weekly-contest-356/problems/count-stepping-numbers-in-range/ */
public class CountSteppingNumbersinRange {

  public static int countSteppingNumbers(String low, String high) {
    int ans = 0;
    String tempHigh = "";
    for (int i = low.length(); i < high.length(); i++) {
      if (i == 1) {
        ans += 10 - Integer.parseInt(low);
      } else {
        while (tempHigh.length() < i) {
          tempHigh += 9;
        }
        for (int j = low.charAt(0) - '0'; j <= 9; j++) {
          ans += count(tempHigh, 1, j);
        }
      }
    }

    for (int j = low.length() == high.length() ? low.charAt(0) - '0' : 1;
        j <= high.charAt(0) - '0';
        j++) {
      ans += count(high, 1, j);
    }

    return ans;
  }

  static int count(String high, int i, int prev) {
    if (i >= high.length()) return 1;
    int ans = 0;
    if (prev == 0 && prev + 1 <= (high.charAt(i) - '0')) {
      ans += count(high, i + 1, prev + 1);
    } else {
      ans += count(high, i + 1, prev - 1);
      if (prev + 1 <= (high.charAt(i) - '0')) {
        ans += count(high, i + 1, prev + 1);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String low = "2", high = "40";
    countSteppingNumbers(low, high);
  }
}
