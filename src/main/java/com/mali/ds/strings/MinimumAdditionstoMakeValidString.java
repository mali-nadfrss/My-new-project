package com.mali.ds.strings;

/* https://leetcode.com/contest/weekly-contest-341/problems/minimum-additions-to-make-valid-string/ */
public class MinimumAdditionstoMakeValidString {

  public static int addMinimum(String word) {

    int ans = 0;
    int i = 0;
    while (i < word.length() - 2) {

      if (word.charAt(i) == 'a') {
        if (word.charAt(i + 1) == 'b') {
          if (word.charAt(i + 2) == 'c') {
            i += 3;
          } else {
            ans++;
            i += 2;
          }
        } else if (word.charAt(i + 1) == 'c') {
          ans += 1;
          i += 2;
        } else {
          i++;
          ans += 2;
        }
      } else if (word.charAt(i) == 'b') {
        ans++;
        if (word.charAt(i + 1) == 'c') {
          i += 2;
        } else {
          i += 1;
          ans++;
        }
      } else if (word.charAt(i) == 'c') {
        i++;
        ans += 2;
      }
    }

    if (i < word.length() - 1) {

      if (word.charAt(i) == 'a') {
        if (word.charAt(i + 1) == 'b') {
          ans++;
          i += 2;
        } else if (word.charAt(i + 1) == 'c') {
          ans += 1;
          i += 2;
        } else {
          ans += 4;
          i += 2;
        }
      } else if (word.charAt(i) == 'b') {
        ans++;
        if (word.charAt(i + 1) == 'c') {
          i += 2;
        } else {
          i += 2;
          ans += 3;
        }
      } else if (word.charAt(i) == 'c') {
        ans += 2;
        i++;
      }
    }
    if (i < word.length()) {

      ans += 2;
    }

    return ans;
  }

  public static void main(String[] args) {

    System.out.println(addMinimum("aaaaba"));
  }
}
