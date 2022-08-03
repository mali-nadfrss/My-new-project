package com.mali.ds.dp.greedy;

import java.util.HashMap;
import java.util.Map;

/* Construct K Palindrome Strings
* https://leetcode.com/problems/construct-k-palindrome-strings/
medium */
public class ConstructKPalindromeStrings {

    public static boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        if (s.length() == k) return true;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.computeIfPresent(c,(v,m)->m+1);
            map.computeIfAbsent(c,m->1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() %2 == 1){
                k-=1;
            }
            if (k <0) return false;
        }
        return k >= 0 ;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("leetcode", 3));
    }
}
