package com.mali.ds.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* https://leetcode.com/problems/online-election/ */
public class TopVotedCandidate {

  Map<Integer, Integer> votesMap = new HashMap<>();
  TreeMap<Integer, Integer> timesMap = new TreeMap<>();

  public TopVotedCandidate(int[] persons, int[] times) {
    int max = 0;
    int cur = persons[0];
    for (int i = 0; i < persons.length; i++) {
      votesMap.put(persons[i], votesMap.getOrDefault(persons[i], 0) + 1);
      if (max <= votesMap.get(persons[i])) {
        timesMap.put(times[i], persons[i]);
        max = votesMap.get(persons[i]);
        cur = persons[i];
      } else {
        timesMap.put(times[i], persons[i]);
      }
    }
  }

  public int q(int t) {
    int key = timesMap.floorKey(t);
    return timesMap.get(key);
  }

  public static void main(String[] args) {
    TopVotedCandidate tp =
        new TopVotedCandidate(new int[] {0, 0, 1, 1, 2}, new int[] {0, 67, 69, 74, 87});

    System.out.println(tp.q(4));
    System.out.println(tp.q(62));
    System.out.println(tp.q(100));
    System.out.println(tp.q(88));
    System.out.println(tp.q(70));
    System.out.println(tp.q(22));
    System.out.println(tp.q(75));
    System.out.println(tp.q(29));
    System.out.println(tp.q(10));
  }
}
