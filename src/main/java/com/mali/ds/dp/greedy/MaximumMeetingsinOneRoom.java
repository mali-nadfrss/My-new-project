package com.mali.ds.dp.greedy;

import java.util.Arrays;
import java.util.Comparator;

/* https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/ */
public class MaximumMeetingsinOneRoom {

  int maximumMeetingsinOneRoom(int[][] meetings) {

    Arrays.sort(meetings, Comparator.comparingInt(o -> o[1]));
    int ans = 1;
    int lastMeetingIndex = 0;
    for (int i = 1; i < meetings.length; i++) {
      if (meetings[i][0] > meetings[lastMeetingIndex][1]) {
        ans++;
      }
    }
    return ans;
  }
}
