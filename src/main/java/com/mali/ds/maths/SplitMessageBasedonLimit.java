package com.mali.ds.maths;

/* https://leetcode.com/problems/split-message-based-on-limit/ */
public class SplitMessageBasedonLimit {

  // <1/1>
  public String[] splitMessage(String message, int limit) {
    if (limit < 6) return new String[0];
    int len = message.length();
    int[] sizes = {
      (limit - 5) * 9,
      (limit - 6) * 9 + (limit - 7) * 90,
      (limit - 7) * 9 + (limit - 8) * 90 + (limit - 9) * 900,
      (limit - 8) * 9 + (limit - 9) * 90 + (limit - 10) * 900 + (limit - 11) * 9000
    };
    int count = 0;
    for (int i : sizes) {
      if (i < len) {
        break;
      } else count++;
    }
    count = count + 5;
    return new String[0];
  }
}
