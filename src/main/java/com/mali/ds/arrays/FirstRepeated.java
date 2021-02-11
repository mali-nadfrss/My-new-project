package com.mali.ds.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* very easy
* */
public class FirstRepeated {

    public static int firstRepeated(int[] arr, int n) {
        //Your code here
        HashSet<Integer> h = new HashSet();
        List l = new ArrayList();
        int ans = -2;
        for (int i = n - 1; i >= 0; i--) {
            if (h.contains(arr[i])) {
                ans = i;
            } else
                h.add(arr[i]);
        }

        return ans + 1;
    }

    public static void main(String[] args) {


        System.out.println(firstRepeated(new int[]{1, 5, 3, 4, 3, 5, 6}, 7));
    }
}
