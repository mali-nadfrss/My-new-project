package com.mali.ds.arrays;

import java.util.ArrayList;

public class SubArray {
    static ArrayList<Integer> subArraySum(int n, int s, int[] m) {

        // Your code here


        int sum = m[0];
        int low = 1;
        int high = 1;
        if (sum == s){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(0, 1);
            ans.add(1,1);
        }
        for (int i = 1; i < n; ) {
            if (sum + m[i] == s) {
                high = i + 1;
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(0, low);
                ans.add(1, high);
                return ans;
            } else if (sum + m[i] < s) {
                high = i + 1;
                sum = sum + m[i];
                i++;
            } else {
                sum = sum - m[low - 1];
                low = low + 1;
            }

        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0, -1);
        return ans;

    }

    public static void main(String[] args) {


        System.out.println(subArraySum(5, 12, new int[]{1,2,3,7,5}));
    }
}
