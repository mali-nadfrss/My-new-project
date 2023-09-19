package com.mali.ds.arrays;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/contest/weekly-contest-360/problems/maximize-value-of-function-in-a-ball-passing-game/ */
public class MaximizeValueofFunctioninaBallPassingGame {

  public static long getMaxFunctionValue(List<Integer> receiver, long k) {

    int len = receiver.size();

    long ans = 0;
    long sum = 0;
    long[] arr = new long[(int) k + len + 1];
    int j = 0;
    arr[j++] = len - 1;
    for (int i = len - 1; i >= 0; i--, j++) {
      arr[j] = receiver.get((int) arr[j - 1]);
      if(receiver.get(i) == i){
        ans = Math.max(ans, (k+1)*i);
      }
    }

    for (int i = (int) k - 1; i >= 0; i--, j++) {
      arr[j] = receiver.get((int) arr[j - 1]);
    }

    for (int i = 0; i <= k; i++) {
      sum += arr[i];
    }

    ans = Math.max(ans, sum);

    for (long i = k + 1; i < arr.length; i++) {
      sum -= arr[(int) (i - (k + 1))];
      sum += arr[(int) i];
      ans = Math.max(ans, sum);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] receiver = {1, 0, 1};
    int k = 2;
    List<Integer> list = new ArrayList<>();
    for (int i : receiver) {
      list.add(i);
    }
    getMaxFunctionValue(list, k);
  }
}
