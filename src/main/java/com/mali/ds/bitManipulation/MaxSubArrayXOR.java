package com.mali.ds.bitManipulation;

/* https://www.geeksforgeeks.org/find-the-maximum-subarray-xor-in-a-given-array/
 * expert */
public class MaxSubArrayXOR {
  public static int maxSubArrayXOR(int arr[], int N) {
    // add code here.
    int max_now = 0; // intitialise the 2 values
    int max_e = 1;
    for(int i = 0; i < N; i++){
      max_e = Math.max(arr[i], max_e ^ arr[i]);

      // check whether current element/Xor is bigger
      // then previous Xor value
      max_now = Math.max(max_e, max_now);  // update the maximum value
    }
    return max_now;
  }

  public static void main(String[] args) {
    int set[] = {8, 1, 2, 12};
    System.out.println(maxSubArrayXOR(set, 3));
  }
}
