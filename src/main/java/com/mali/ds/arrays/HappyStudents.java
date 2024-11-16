package com.mali.ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* https://leetcode.com/contest/weekly-contest-363/problems/happy-students/ */
public class HappyStudents {

    public static int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int max = 0;

        for(int i = 0 ; i < nums.size() ; i++){
            max = Math.max(max, nums.get(i));
            nums.set( i, max);
        }

        int ans = 0;

        for(int i = nums.size()-1 ; i >= 0 ; i--){
            if(nums.get(i) <= i) ans++;
        }

        if(nums.get(0) != 0) ans++;

        return ans;
    }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(1);
    list.add(0);
    list.add(1);
    countWays(list);
  }
}
