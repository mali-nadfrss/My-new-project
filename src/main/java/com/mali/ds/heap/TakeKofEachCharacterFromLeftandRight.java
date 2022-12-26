package com.mali.ds.heap;

/* https://leetcode.com/contest/weekly-contest-325/problems/take-k-of-each-character-from-left-and-right/ */
public class TakeKofEachCharacterFromLeftandRight {

  public static int takeCharacters(String s, int k) {

    int[] arr = new int[3];
    for (char c : s.toCharArray()) {
      arr[c - 'a']++;
    }
    if (arr[0] < k || arr[1] < k || arr[2] < k) return -1;
    int ans = arr[0] + arr[1] + arr[2];
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      arr[s.charAt(i) - 'a']--;
      while (arr[0] < k || arr[1] < k || arr[2] < k) {
        arr[s.charAt(start++) - 'a']++;
      }
      ans = Math.min(ans, arr[0] + arr[1] + arr[2]);
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(takeCharacters("acbcc", 1));
  }
}
