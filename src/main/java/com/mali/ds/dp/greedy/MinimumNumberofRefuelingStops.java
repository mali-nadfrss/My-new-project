package com.mali.ds.dp.greedy;

/* https://leetcode.com/problems/minimum-number-of-refueling-stops/
 * Hard */
public class MinimumNumberofRefuelingStops {

  public static int minRefuelStops(int target, int startFuel, int[][] stations) {
    if (target <= startFuel) return 0;
   recursive(target - startFuel, startFuel, stations, 0,0);
   if (fAns == Integer.MAX_VALUE) return -1;
   return fAns;
  }

  static int fAns = Integer.MAX_VALUE;

  static void recursive(int target, int startFuel, int[][] stations, int i, int ans) {

    // we have reached our target
    if (target <= 0) {
      fAns = Math.min(ans, fAns);
      return ;
    }
    // we have reached end but not reached our target || no fuel, it cannot reach there so return
    if (i >= stations.length || startFuel < stations[i][0]) {
      return ;
    }

    // now we have 2 choices either to refuel at current station or leave and refuel at next station
    startFuel -= stations[i][0];

    // refuel --> lessen the target distance and add station fuel to startFuel and do ans++
    recursive(target - stations[i][0], startFuel + stations[i][1], stations, i + 1, ans+1);

    // dont refuel , just lessen target distance and go to next station.
    recursive(target - stations[i][0], startFuel, stations, i + 1, ans);
  }

  public static void main(String[] args) {
   // int[][] arr = new int[][] {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
    int[][] arr = new int[][] {{50, 50}};
    System.out.print(minRefuelStops(100, 50, arr));
  }
}
