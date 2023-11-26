package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Test123 {

  private static int[][] processPairs(int[][] pairs) {

    TreeMap<Integer, int[]> map = new TreeMap<>();
    int start = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    List<int[]> result = new ArrayList<>();

    for (int[] pair : pairs) {
      map.put(pair[1], pair);
      if (pair[1] < start) {
        start = pair[1];
        min = pair[0];
      }
    }
    int[] currentPair = new int[2];
    currentPair[0] = min;
    while (map.ceilingKey(start+1) != null) {
      int ceilKey = map.ceilingKey(start+1);
      int[] ceilPair = map.get(ceilKey);
      if (ceilPair[0] > start) {
        currentPair[1] = map.get(start)[1];
        result.add(currentPair);
        //initialize new pair
        currentPair = new int[2];
        currentPair[0] = ceilPair[0];

      }
      start = ceilKey;
    }
    currentPair[1] = map.get(start)[1];
    result.add(currentPair);

    int[][] ans = new int[result.size()][2];
    int i = 0;
    for (int[] pair : result) {
      ans[i++] = pair;
      System.out.println(pair[0]+" "+pair[1]);
    }


    return ans;
  }

  public static void main(String[] args) {
    int input[][] = {{8, 10}, {15, 18}, {1, 3}, {2, 6}};
    int output[][] = {{1, 6}, {8, 10}, {15, 18}};

    processPairs(input);
  }
}
