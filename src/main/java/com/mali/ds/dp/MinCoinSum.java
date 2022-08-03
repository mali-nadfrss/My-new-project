package com.mali.ds.dp;

import java.util.Arrays;

public class MinCoinSum {

    static int minCoins(int[] change, int amount) {

        int l = change.length;
        int[][] ans = new int[l][amount+1];
        Arrays.sort(change);
        for (int i = 0; i <= amount; i++) {
            if (i % change[0] == 0) {
                ans[0][i] = i / change[0];
            } else {
                ans[0][i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < l; i++) {
            for (int j = 0; j <= amount; j++) {
                if (change[i] > j){
                    ans[i][j] = ans[i-1][j];
                }else{
                    ans[i][j] = Integer.min(1+ans[i][j-change[i]],ans[i-1][j]);
                }
            }

        }
        return ans[l - 1][amount];
    }

    public static void main(String[] args) {
        int[] change = {1,3,6,9};
        int amount = 10;
        System.out.println(minCoins(change, amount));
    }
}
