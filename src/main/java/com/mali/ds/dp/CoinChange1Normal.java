package com.mali.ds.dp;

import java.util.Arrays;

/* https://www.youtube.com/watch?v=L27_JpN6Z1Q */
public class CoinChange1Normal {

    static int coinChange(int[] change, int amount){
        int[][] values = new int[change.length][amount];
        values[0][0] = 0;
        Arrays.sort(change);
        for (int i = 1; i < amount; i++) {
            if (i % change[0] == 0){
                values[0][i] = i/change[0];
            }
        }
        for (int i = 1; i < change.length; i++) {
            for (int j = 0; j < amount; j++) {
                if (change[i] > j){
                    values[i][j] = values[i-1][j];
                }
                else {
                    values[i][j] = values[i-1][j]+values[i][j-change[i]];
                }
            }
        }
        return values[change.length -1][amount-1];
    }

    public static void main(String[] args) {
        int[] change = {2,3,5,6};
        int amount = 10;
        System.out.println(coinChange(change, amount));
    }
}
