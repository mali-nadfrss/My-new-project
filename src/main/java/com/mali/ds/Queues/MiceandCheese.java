package com.mali.ds.Queues;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/* https://leetcode.com/contest/weekly-contest-339/problems/mice-and-cheese/ */
public class MiceandCheese {

    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {

        Set<Integer> set = new HashSet<>();
        int ans = 0;

        //value, index, diff
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < reward1.length; i++) {
            pq.add(new int[]{reward1[i], i, reward2[i]-reward1[i] });
        }
        while (k > 0){
            int[] item = pq.poll();
            ans += item[0];
            set.add(item[1]);
            k--;
        }
        for(int i = 0; i < reward2.length; i++) {
            if (!set.contains(i)){
                ans += reward2[i];
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] r1 = {1,1,3,4};
        int[] reward2 = {4,4,1,1};
        int k= 2;
        System.out.println(miceAndCheese(r1, reward2, k));
    }

}
