package com.mali.ds.strings;

public class LongestSubString {

  static int subSequenceLength(String s) {
    // Code here
    int[] freq = new int[256];
    int l = s.length();
    int left = 0;
    int ans = 0;
    int i = 0;
    for (; i < l; i++) {
      freq[s.charAt(i)]++;
      if (freq[s.charAt(i)] > 1) {
        while (freq[s.charAt(i)] > 1) {
          freq[s.charAt(left)]--;
          left++;
        }
      }
      if (i - left + 1 > ans) {
        ans = i - left + 1;
      }
    }
    if (i - left > ans) {
      ans = i - left;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(subSequenceLength("ababcdeaaab"));
  }
}
