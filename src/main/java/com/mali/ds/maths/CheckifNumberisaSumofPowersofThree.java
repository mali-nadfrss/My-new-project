package com.mali.ds.maths;

import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
* medium */
public class CheckifNumberisaSumofPowersofThree {
    public static boolean checkPowersOfThree(int n) {
        Set<Integer> set = new HashSet<>();
        while(true){
            int a = (int)(Math.log(n)/Math.log(3));  // calculating the largest power of 3 just smaller than n in other words, 3^a < n &&  a is the greatest possible.
            if(set.contains(a)) return false;
            set.add(a);
            n = n - (int)Math.pow(3,a);
            if(n==0) return true;
        }
       // return n == 0 || n==1;

    }

    public static void main(String[] args) {

        System.out.println(checkPowersOfThree(6574365));

    }
}
