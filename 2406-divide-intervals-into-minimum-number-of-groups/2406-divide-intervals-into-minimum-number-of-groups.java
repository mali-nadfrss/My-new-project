class Solution {
    public int minGroups(int[][] intervals) {
        
       Arrays.sort(
        intervals,
        (o1, o2) -> {
          if (o1[0] == o1[1]) {
            return o1[1] - o2[1];
          }
          return o1[0] - o2[0];
        });

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < intervals.length; i++) {

      if (!pq.isEmpty() && pq.peek() < intervals[i][0]) {
        pq.poll();
      }
      pq.add(intervals[i][1]);
    }

    return pq.size();
        
    }
}