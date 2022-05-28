package com.mali.ds.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;

/* https://leetcode.com/problems/time-based-key-value-store/
 * medium */
public class TimeMap {

  public Map<String, TreeMap<Integer, String>> map;

  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    map.computeIfAbsent(
        key, (Function<? super String, ? extends TreeMap<Integer, String>>) new TreeMap());
    map.get(key).put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    if (map.containsKey(key)) {
      int floor = map.get(key).floorKey(timestamp);
      return map.get(key).get(floor);
    }
    return null;
  }
}
