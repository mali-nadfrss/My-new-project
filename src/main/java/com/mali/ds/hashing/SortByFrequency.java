package com.mali.ds.hashing;

import java.util.*;

/* medium 4
 * sort values sby freq \
 * https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621
 */
public class SortByFrequency {
    static ArrayList<Integer> sortByFreq(int arr[], int n) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            ans.add(i);
        }


        Collections.sort(ans, (o1, o2) -> {
            int i1 = map.get(o1);
            int i2 = map.get(o2);
            if (i1 != i2) {
                return i2 - i1;
            }
            return (int) o1 - (int) o2;
        });

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 2, 3};
        System.out.println(sortByFreq(A, 7));
    }
}
