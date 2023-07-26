package com.mali.ds.dp.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/jump-game/
https://leetcode.com/problems/jump-game-ii/
https://leetcode.com/problems/jump-game-iii/
 * Medium
 * */
public class JumpGame {

  public static int canJumpII(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];
    Arrays.fill(dp, len);
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
        dp[j] = Math.min(dp[j], dp[i] + 1);
      }
    }

    return dp[len - 1];
  }

  /* https://leetcode.com/problems/jump-game-iii/ */
  public static boolean canReach(int[] arr, int start) {
    return recursion(arr, start, new boolean[arr.length]);
  }

  private static boolean recursion(int[] arr, int start, boolean[] visited) {
    if (start < 0 || start >= arr.length) {
      return false;
    }
    if (arr[start] == 0) return true;
    if (visited[start]) return false;
    visited[start] = true;
    return recursion(arr, start + arr[start], visited)
        || recursion(arr, start - arr[start], visited);
  }

  /* https://leetcode.com/problems/jump-game-iv/
   * Hard
   * based on BFS --> use queue
   * DFS --> use Stack
   * */
  public static int minJumpsiv(int[] arr) {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (map.get(arr[i]) == null) map.put(arr[i], new ArrayList<>(i));
      else map.get(arr[i]).add(i);
    }
    return recursioniv(arr, 0, 0, map, new boolean[arr.length][arr.length]);
  }

  private static int recursioniv(
      int[] arr, int i, int from, Map<Integer, ArrayList<Integer>> map, boolean[][] visited) {
    if (i < 0 || i >= arr.length || visited[i][from]) return 1000000;
    if (i == arr.length - 1) return 0;
    int ans = 1000000;
    visited[i][from] = true;
    if (map.get(arr[i]) != null) {
      for (Integer k : map.get(arr[i])) {
        ans = Math.min(1 + recursioniv(arr, k, i, map, visited), ans);
      }
    }
    ans = Math.min(1 + recursioniv(arr, i - 1, i, map, visited), ans);
    ans = Math.min(1 + recursioniv(arr, i + 1, i, map, visited), ans);
    return ans;
  }

  public static int minJumps(int[] nums) {

    int curLevel = 0;
    int nxtLevel = 0;
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > curLevel) {
        ans++;
        curLevel = nxtLevel;
      }
      nxtLevel = Math.max(nxtLevel, i + nums[i]);
    }
    return ans;
  }

  public static boolean canJump(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (max < i) return false;
      max = Math.max(max, i + nums[i]);
    }
    return max >= nums.length - 1;
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 0, 4};
    int[] nums1 = {2, 3, 1, 1, 4};
    System.out.println(canJump(nums));
    System.out.println(canJumpII(nums1));

    System.out.println(minJumps(nums1));
    int[] nums2 = {4, 2, 3, 0, 3, 1, 2};
    System.out.println(canReach(nums2, 2));

    int[] nums4 = {7, 7, 2, 1, 7, 7, 7, 3, 4, 1};
    System.out.println(minJumpsiv(nums4));
  }
}
