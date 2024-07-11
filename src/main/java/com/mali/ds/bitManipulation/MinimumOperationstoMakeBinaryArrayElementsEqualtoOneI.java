package com.mali.ds.bitManipulation;

/*https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/ */
public class MinimumOperationstoMakeBinaryArrayElementsEqualtoOneI {


  public int minOperationsII(int[] nums) {

    int ans = 0;
    int flag = 0;

    for(int i = 0 ; i < nums.length ; i++){
      if(nums[i] == 0 && flag == 0 || nums[i] == 1 && flag == 1){
        ans++;
        flag = 1^flag;
      }
    }
    return ans;
  }

  public static int minOperations(int[] nums) {

    int ans = 0;
    int len = nums.length ;
    for (int i = 0; i < len - 2; i++) {
      if (nums[i] == 0) {
        ans++;
        nums[i] = 1;
        nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
        nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
      }
    }

    if(nums[len -1] == 0 || nums[len-2] == 0 || nums[len-3] == 0) return -1;

    return ans;
  }

  public static void main(String[] args) {

    int[] nums = {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1};
    System.out.println(minOperations(nums));
  }
}
