package com.mali.ds.dp;

public class ShareMaxProfit {

    static int calculate(int[] values, int k){
        int l = values.length;
        int[][] ans = new int[k+1][l];
        for (int i = 0; i < l; i++) {
            ans[0][i] = 0;
        }
        for (int i = 0; i <= k; i++) {
            ans[i][0] = 0;
        }

        for (int i = 1; i < k+1; i++) {
            for (int j = 1; j < l ; j++) {
                int max = 0;
                for (int m = 0; m < j; m++) {
                    max = Math.max(max,ans[i-1][m]+values[j]-values[m]);
                }
                ans[i][j] = Math.max(ans[i][j-1],max);
            }
        }
        return ans[k][l-1];

    }

    public static void main(String[] args) {
     int[] values = {10, 22, 5, 75, 65, 80};
     int k = 2;
     System.out.println(calculate(values, k));

     int[] values1 = {20, 580, 420, 900};
     int k1 = 2;
     System.out.println(calculate(values1, k1));
     int[] values2 = {100, 90, 80, 50, 25};
     int k2 = 1;
     System.out.println(calculate(values2, k2));


    }
}
