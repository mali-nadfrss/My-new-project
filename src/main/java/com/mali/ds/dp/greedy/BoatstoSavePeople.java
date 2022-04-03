package com.mali.ds.dp.greedy;

import java.util.Arrays;

/* https://leetcode.com/problems/boats-to-save-people/
 * medium */
public class BoatstoSavePeople {
  public static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int ans = 0;
    for (int i = 0, j = people.length - 1; i <= j; ans++, j--) {
      if (people[i] + people[j] <= limit) {
        i++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(numRescueBoats(new int[] {3, 2, 2, 1}, 3));
  }
}
