package com.mali.ds.bitManipulation;

/* https://leetcode.com/contest/biweekly-contest-121/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/ */
public class MinimumNumberofOperationstoMakeArrayXOREqualtoK {

    public static int minOperations(int[] nums, int k) {

        int[] c = new int[32];

        int t = 1 << 30;
        int i = 31;

        while(t > 0 ){
            if((t & k) != 0){
                c[i] = 1;
            }
            t = t >> 1;
            i--;
        }

        int[] c1 = new int[32];

        for(int num : nums){
            t = 1 << 30;
            i = 31;

            while(t > 0 ){
                if((t & num) != 0){
                    c1[i] += 1;
                }
                t =  t >> 1;
                i--;
            }
        }

        int ans = 0;
        for( i = 0 ; i < 32 ; i++){
            if((c[i] %2 == 0 && c1[i] % 2 != 0) || (c[i] %2 != 0 && c1[i] % 2 == 0) ){
                ans++;
            }
        }
        return ans;

    }

    public static void main(String[] args){
        System.out.println("hi");
        int[]  nums = {2,0,2,0};
        int k = 0;
        minOperations(nums, k);
    }



}
