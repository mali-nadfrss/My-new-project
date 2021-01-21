package com.mali.ds.strings;

public class SubString {

    static int strstr(String str, String target) {
        int l = str.length();
        int m = target.length();
        int j = 0;
        int i = 0;
        for (; i < l; i++) {
            if (j == m) {
                return i - m;
            }
            if (str.charAt(i) == target.charAt(j)) {
                j++;
            } else {
                j = 0;
            }
        }
        if (j == m) {
            return i - m;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strstr("abcabcabcd", "abcd"));
    }

}
