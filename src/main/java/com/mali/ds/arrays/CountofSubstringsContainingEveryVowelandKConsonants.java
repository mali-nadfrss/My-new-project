package com.mali.ds.arrays;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/contest/weekly-contest-417/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/ */
public class CountofSubstringsContainingEveryVowelandKConsonants {

    public static int countOfSubstrings(String word, int k) {

        int len = word.length();
        int[] c = new int[len];
        List<int[]> v = new ArrayList<>();
        v.add(new int[5]);
        char ch = word.charAt(0);
        if (ch == 'a') {
            v.get(0)[0]++;
        } else if (ch == 'e') {
            v.get(0)[1]++;
        } else if (ch == 'i') {
            v.get(0)[2]++;
        } else if (ch == 'o') {
            v.get(0)[3]++;
        } else if (ch == 'u') {
            v.get(0)[4]++;
        } else {
            c[0] = 1;
        }

        for (int i = 1; i < len; i++) {
            ch = word.charAt(i);
            v.add(new int[5]);
            if (ch == 'a') {
                v.get(i)[0]++;
            } else if (ch == 'e') {
                v.get(i)[1]++;
            } else if (ch == 'i') {
                v.get(i)[2]++;
            } else if (ch == 'o') {
                v.get(i)[3]++;
            } else if (ch == 'u') {
                v.get(i)[4]++;
            } else {
                c[i]++;
            }
        }

        int ans = 0;
        int tk = 0;
        boolean isV = false;
        int ac = 0;
        int ec = 0;
        int ic = 0;
        int oc = 0;
        int uc = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            tk += c[i];
            ac += v.get(i)[0];
            ec += v.get(i)[1];
            ic += v.get(i)[2];
            oc += v.get(i)[3];
            uc += v.get(i)[4];
            if (ac > 0 && ec > 0 && ic > 0 && oc > 0 && uc > 0 && tk == k) {
                ans++;
            }
            while (tk > k) {
                ac -= v.get(start)[0];
                ec -= v.get(start)[1];
                ic -= v.get(start)[2];
                oc -= v.get(start)[3];
                uc -= v.get(start)[4];
                tk -= c[start];
                start++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        countOfSubstrings("iqeaouqi", 2);
    }

}
