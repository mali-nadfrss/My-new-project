package com.mali.ds.dp;

/* https://leetcode.com/problems/k-inverse-pairs-array/description/ */
public class KInversePairsArray {

    public static int kInversePairs(int n, int k) {
        if(k ==0 ) return 1;
        int mod = (int)Math.pow(10, 9)+7;
        for(int  i =0 ; i < n ; i++){

        }
        return 1;
    }

    int recursion(int index, int value, int n, int k){
        if(index >= n || k < 0) return 0;
        if(k == 1) return 1;
        if(value >= n){
            for(int i = 0; i < n; i++) {

            }
        } else {

        }
        return 1;
    }

}
