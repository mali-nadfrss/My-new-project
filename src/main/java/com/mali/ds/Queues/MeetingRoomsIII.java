package com.mali.ds.Queues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/meeting-rooms-iii/ */
public class MeetingRoomsIII {

  public static int mostBooked(int n, int[][] meetings) {

    // arrange the meetings in order wise.
    Arrays.sort(meetings, (o1, o2) -> {
      if (o1[1] == o2[1]){
        return o1[0] - o2[0];
      }
      return o1[1] - o2[1];
    });

    // use this as a empty meetings store, o[0] --> room id. o[1] --> end time
    PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));

    // use this as ongoing meetings store, omm with least end time will be on top
    PriorityQueue<long[]> mq =
        new PriorityQueue<>(
            (o1, o2) -> {
              if (o1[1] == o2[1]) {
                return Long.compare(o1[0], o2[0]);
              } else return Long.compare(o1[1], o2[1]);
            });

    for (int i = 0; i < n; i++) {
      //  add all rooms to store initially with end time as 0
      pq.add(new long[] {i, 0});
    }
    long[] count = new long[n];

    for (int i = 0; i < meetings.length; i++) {

      // poll rooms whose meeting end time is less than current meeting start time and add to store
      while (!mq.isEmpty() && mq.peek()[1] <= meetings[i][0]) {
        pq.add(new long[] {mq.peek()[0], mq.poll()[1]});
      }

      // poll the room from store and add to an going room
      // add its end time as last end time + meeting duration
      if (!pq.isEmpty()) {
        mq.add(
            new long[] {
              pq.peek()[0],
              Math.max(pq.peek()[1], meetings[i][0]) + (meetings[i][1] - meetings[i][0])
            });
        count[(int) pq.poll()[0]]++;
      } else {
        //if we found no room in empty meeting store, then take out 1 from ongoing which completes first
        mq.add(
            new long[] {
              mq.peek()[0],
              Math.max(mq.peek()[1], meetings[i][0]) + (meetings[i][1] - meetings[i][0])
            });
        count[(int) mq.poll()[0]]++;
      }
    }

    int ans = 0;
    long max = 0;

    //finally find the smallest room with maximum meetings
    for (int i = 0; i < n; i++) {
      if (count[i] > max) {
        ans = i;
        max = count[i];
      }
    }
    return ans;
  }

  public static void main(String[] args) {

    int[][] A = {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};
    System.out.println(mostBooked(3, A));
  }
}
