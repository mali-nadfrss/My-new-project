package com.mali.ds.dp;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/maximum-length-of-pair-chain/*/
public class LongestChain {
    static int calc(int[][] values) {
        int l = values.length;
        int[] ans = new int[l];
        Arrays.sort(values, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        for (int i = 0; i < l; i++) {
            ans[i] = 1;
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (values[i][0] > values[j][1] && ans[j] >= ans[i]) {
                    ans[i] = ans[j] + 1;
                }
            }
        }
        int ans1 = 0;
        for (int i = 0; i < l; i++) {
            if (ans[i] > ans1) {
                ans1 = ans[i];
            }
        }
        return ans1;
    }

    public static void main(String[] args) {
        int[][] values = {{1, 2}, {2, 3}, {3, 4}};
        int[][] values1 = {{5, 24}, {15, 28}, {27, 40}, {39, 60}, {50, 90}};
        System.out.println(calc(values));
        System.out.println(calc(values1));
    }
}
