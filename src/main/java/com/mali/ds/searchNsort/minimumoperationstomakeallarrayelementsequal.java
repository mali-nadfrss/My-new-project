package com.mali.ds.searchNsort;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-338/problems/minimum-operations-to-make-all-array-elements-equal/*/
public class minimumoperationstomakeallarrayelementsequal {


  static TreeSet<Integer> set = new TreeSet();

  /* https://leetcode.com/contest/weekly-contest-338/problems/prime-subtraction-operation/ */
  public static boolean primeSubOperation(int[] nums) {


    if(set.size() <= 0){
      set.add(1);
      set.add(2);
      for(int i = 3; i < 1000; i++ ){

        int sqrt = (int)Math.sqrt(i);
        boolean flag = true;
        for(int j = 2; j < sqrt+1 ;j++ ){
          if(i%j == 0){
            flag = false;
            break;
          }
        }
        if(flag){
          set.add(i);
        }

      }
    }

    for(int i = nums.length-2 ; i >= 0; i--){

      if(nums[i] < nums[i+1]){
        continue;
      }
      int rem = nums[i]-nums[i+1];
      Integer k = set.ceiling(rem+1);
      if(k != null){
        nums[i] = nums[i]-k;
        if(nums[i] >= nums[i+1]){
          return false;
        }
      } else{
        return false;
      }

    }
    return true;
  }

  public static List<Long> minOperations(int[] nums, int[] queries) {

    List<Long> ans = new ArrayList();
    Arrays.sort(nums);

    long total = 0;
    TreeMap<Integer, Long[]> map = new TreeMap<>();
    long cnt = 0;
    for (int num : nums) {
      total += num;
      cnt++;
      map.put(num, new Long[] {total, cnt});
    }

    for (int query : queries) {

      cnt = 0;
      Integer key = map.floorKey(query - 1);
      if (key != null) {

        long len = map.get(key)[1];
        long sum = map.get(key)[0];
        cnt += Math.abs(sum - query * len);
        cnt += Math.abs(total - sum - query * (nums.length - len));

      } else {

        cnt += Math.abs(total - query * nums.length);
      }

      ans.add(cnt);
    }
    return ans;
  }

  public static void main(String[] args) {

    primeSubOperation(new int[]{5, 8, 3});
    int[] nums = {3, 1, 6, 8};
    int[] queries = {1, 5};
    System.out.println(minOperations(nums, queries));


  }
}
