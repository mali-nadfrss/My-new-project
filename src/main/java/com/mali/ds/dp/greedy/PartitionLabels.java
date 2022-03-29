package com.mali.ds.dp.greedy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* https://leetcode.com/problems/partition-labels/
 * medium */
public class PartitionLabels {

  public static List<Integer> partitionLabels(String s) {

    if (s.equals("")) return new ArrayList<>();
    Map<Character, Integer[]> map = new LinkedHashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (map.get(s.charAt(i)) == null) {
        map.put(s.charAt(i), new Integer[] {i, i});
      } else {
        map.get(s.charAt(i))[1] = i;
      }
    }
    List<Integer> ans = new ArrayList<>();
    int start = -1;
    int end = -1;
    int index = -1;
    for (Map.Entry<Character, Integer[]> e : map.entrySet()) {
      if (e.getValue()[0] > end) {
        start = e.getValue()[0];
        end = e.getValue()[1];
        ans.add(end - start + 1);
        index++;
      } else {
        if (e.getValue()[1] > end) {
          ans.set(index, e.getValue()[1] - start + 1);
          end = e.getValue()[1];
        }
      }
    }
    ans.forEach(k -> System.out.println(k));
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
  }
}
