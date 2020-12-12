package com.mali.ds.maths;

import java.util.ArrayList;

/* https://practice.geeksforgeeks.org/problems/exactly-3-divisors/1/?track=dsa-workshop-1-mathematics&batchId=308 */
public class Divisors {

    public int exactly3Divisors(int N) {
        //Your code here
        if (N < 4) {
            return 0;
        }
        int ans = 1;
        int k = (int) Math.sqrt(N);
        for (int i = 3; i < k; i = i + 2) {

            if (isPrime(i)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isPrime(int i) {
        int k = (int)Math.sqrt(i);
        int[] A = new int[4];
        ArrayList a = new ArrayList();

        for (int j = 2; j <= k ; j++) {
            if (i %j == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Divisors d = new Divisors();
        d.exactly3Divisors(999999);
    }
}
