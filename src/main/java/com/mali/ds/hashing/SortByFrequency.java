package com.mali.ds.hashing;

import java.util.*;

/* medium 4
 * sort values sby freq
 * https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621
 */
public class SortByFrequency {
    static ArrayList<Integer> sortByFreq(ArrayList<Integer> array, int n, int k) {
        // add your code here

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Collections.sort(array, (o1, o2) -> {
            int i1 = map.get(o1);
            int i2 = map.get(o2);
            if (i1 != i2) {
                return i2 - i1;
            }
            return o2 - o1;
        });

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; ans.size() < k; i++) {
            if (!ans.contains(array.get(i))) {
                ans.add(array.get(i));
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Integer[] A = {8, 1, 1, 2, 2, 3, 3, 3, 4};
        System.out.println(sortByFreq(new ArrayList<Integer>((Collection<? extends Integer>) Arrays.asList(A)), 8, 2));
    }
}
