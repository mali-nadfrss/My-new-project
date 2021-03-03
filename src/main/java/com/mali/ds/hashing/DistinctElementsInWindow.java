package com.mali.ds.hashing;

import java.util.*;

/*
easy 2
count distinct elements in every window
https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window
* */
public abstract class DistinctElementsInWindow {

    static ArrayList<Integer> countDistinct(int A[], int n, int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1 && i < n; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList();
        int m = 0;
        for (int i = 0; i < n - k + 1; i++) {
            if (map.containsKey(A[i + k - 1])) {
                map.put(A[i + k - 1], map.get(A[i + k - 1]) + 1);
            } else {
                map.put(A[i + k - 1], 1);
            }
            ans.add(map.size());
            if (map.get(A[m]) > 1) {
                map.put(A[m], map.get(A[m]) - 1);
            } else {
                map.remove(A[i]);
            }
            m++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 2, 3};
        System.out.println(countDistinct(A, 7, 4));
    }
}
