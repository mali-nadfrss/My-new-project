package com.mali.ds.strings;

/* https://leetcode.com/problems/string-transformation/ */
public class StringTransformation {

    public static int numberOfWays(String s, String t, long k) {

        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for(char c : s.toCharArray()){
            chars1[c-'a']++;
        }

        for(char c : t.toCharArray()){
            chars2[c-'a']++;
        }

        for(int i= 0 ; i< 26 ; i++){
            if(chars1[i] != chars2[i]) return 0;
        }
        len = s.length();
        return recursion(s, t, k, new long[s.length()] );

    }

    static long len;

    static int recursion(String s, String t, long k, long[] dp){
        if(k == 0 ){
            return s.equals(t) ? 1 : 0 ;
        }
        if(k >= s.length()) {
            long mod = k%len;
            return (int)dp[(int) mod];
        }
        int ans = 0;
        for(int i = 1 ; i < s.length() ; i++){
            dp[i] = recursion(s.substring(i)+s.substring(0, i), t, k-1, dp);
            ans += dp[i];
        }
        return ans;
    }

}
