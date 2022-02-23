package com.mali.ds.dp.distinctWays;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/count-vowels-permutation/
 * */
public class CountVowelsPermutation {

  public static int countVowelPermutation(int n) {
    map.put('a', new char[] {'e'});
    map.put('e', new char[] {'a', 'i'});
    map.put('i', new char[] {'e', 'a', 'o', 'u'});
    map.put('o', new char[] {'i', 'u'});
    map.put('u', new char[] {'a'});

    map2.put('a', 0);
    map2.put('e', 1);
    map2.put('i', 2);
    map2.put('o', 3);
    map2.put('u', 4);
    char[] c = new char[] {'a', 'e', 'i', 'o', 'u'};
    int ans = 0;
    for (char k : c) {
      ans = (ans + recursion(k, n - 1, new Integer[n + 1][5])) % MOD;
    }
    return ans % MOD;
  }

  static final Map<Character, char[]> map = new HashMap<>();
  static final Map<Character, Integer> map2 = new HashMap<>();
  static final int MOD = 1000000007;

  static int recursion(char c, int n, Integer[][] dp) {
    if (n == 0) return 1;
    if (n < 0) return 0;
    if (dp[n][map2.get(c)] != null) return dp[n][map2.get(c)];
    int ans = 0;
    for (char k : map.get(c)) {
      ans = (ans + recursion(k, n - 1, dp)) % MOD;
    }
    dp[n][map2.get(c)] = ans % MOD;
    return dp[n][map2.get(c)];
  }

  public static void main(String[] args) {
    System.out.println(countVowelPermutation(999));
  }
}
