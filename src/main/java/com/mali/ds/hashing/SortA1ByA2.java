package com.mali.ds.hashing;

import java.util.*;

public class SortA1ByA2 {

  // A1[] : the input array-1
  // N : size of the array A1[]
  // A2[] : the input array-2
  // M : size of the array A2[]
  public static Object[] sortA1ByA2(int[] A1, int N, int[] A2, int M) {
    // Your code here
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < M; i++) {
      map.put(A2[i], i);
    }
    List ans = Arrays.asList(A1);
    Collections.sort(
        ans,
        (o1, o2) -> {
          if (map.containsKey(o1) && map.containsKey(o2)) {
            return map.get(o1) - map.get(o2);
          } else if (map.containsKey(o1)) {
            return 1;
          } else if (map.containsKey(o2)) {
            return -1;
          } else {
            return (int) o2 - (int) o1;
          }
        });
    return ans.toArray();
  }

  public static void main(String[] args) {
    int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    int A2[] = {2, 1, 8, 3};
    System.out.println(Arrays.stream(sortA1ByA2(A1, 11, A2, 4)).toArray());
  }
}
