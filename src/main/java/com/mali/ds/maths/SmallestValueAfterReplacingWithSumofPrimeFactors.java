package com.mali.ds.maths;

/* https://leetcode.com/contest/weekly-contest-324/problems/smallest-value-after-replacing-with-sum-of-prime-factors/ */
public class SmallestValueAfterReplacingWithSumofPrimeFactors {


    public static int smallestValue(int n) {

        int sum = 0;
        int k = n;
        for(int i = 2 ; i <= n ; ){
            if(n % i == 0){
                sum +=i;
                n = n/i;
            } else{
                i++;
            }

        }

        if(sum == k ) return k;
        return smallestValue(sum);

    }

  public static void main(String[] args) {
    System.out.println(smallestValue(15));
  }
}
