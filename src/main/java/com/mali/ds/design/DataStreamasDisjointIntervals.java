package com.mali.ds.design;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/* https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 * Hard */
public class DataStreamasDisjointIntervals {

  class BSTNode {

    BSTNode left;
    BSTNode right;
    int val;
    int end;

    BSTNode(int val, int end) {
      this.val = val;
      this.end = end;
    }
  }

  BSTNode head;

  TreeMap<Integer, Integer> map = new TreeMap<>();

  public void addNum(int val) {

    Integer floor = map.floorKey(val);
    Integer ceil = map.ceilingKey(val);

    if (map.containsKey(val)) return;

    if (floor == null && ceil == null) {
      map.put(val, val);
    }
    else if (floor != null && map.get(floor) >= val) return;

    // 1,1 & 3,3
     else if (floor != null && ceil != null && map.get(floor) + 1 == val && ceil - 1 == val) {
      map.put(floor, map.get(ceil));
      map.remove(ceil);
    }
    // only 3,3
    else if (ceil !=null && ceil - 1 == val) {
      map.put(val, map.get(ceil));
      map.remove(ceil);
    }
    // only 1,1
    else if ( floor != null && map.get(floor) + 1 == val) {
      map.put(floor, val);
    }
    // other cases like 1,1 and 5,7 but insert 3
    else {
      map.put(val, val);
    }
  }

  public int[][] getIntervals() {
    if (map.size() == 0) return null;
    int[][] ans = new int[map.size()][2];
    int i = 0;
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      ans[i][0] = e.getKey();
      ans[i][1] = e.getValue();
      i++;
    }
    return ans;
  }

  public static void main(String[] args) {
    DataStreamasDisjointIntervals obj = new DataStreamasDisjointIntervals();
    obj.addNum(6);
    System.out.println(Arrays.deepToString(obj.getIntervals()));
    obj.addNum(0);
    System.out.println(Arrays.deepToString(obj.getIntervals()));
    obj.addNum(4);
    System.out.println(Arrays.deepToString(obj.getIntervals()));
    obj.addNum(8);
    System.out.println(Arrays.deepToString(obj.getIntervals()));
    obj.addNum(7);
    System.out.println(Arrays.deepToString(obj.getIntervals()));
    obj.addNum(6);
    System.out.println(Arrays.deepToString(obj.getIntervals()));
    obj.addNum(4);
    System.out.println(Arrays.deepToString(obj.getIntervals()));
    obj.addNum(7);
    System.out.println(Arrays.deepToString(obj.getIntervals()));
    obj.addNum(5);
    System.out.println(Arrays.deepToString(obj.getIntervals()));

  }
}
