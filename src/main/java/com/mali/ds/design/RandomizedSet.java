package com.mali.ds.design;

import java.util.*;

/* https://leetcode.com/problems/insert-delete-getrandom-o1/
 * medium */
public class RandomizedSet {

  Map<Integer, Integer> map = new HashMap<>();
  List<Integer> list = new ArrayList<>();

  public RandomizedSet() {}

  public boolean insert(int val) {
    if (map.get(val) != null) return false;
    map.put(val, list.size());
    list.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (map.get(val) == null) return false;
    int loc = map.get(val);
    int size = list.size();
    int val1 = list.get(size - 1);
    list.set(loc, val1);
    map.put(val1, loc);
    // 1, 0 2,1, 5,2
    map.remove(val);
    list.remove(size - 1);
    return true;
  }

  Random random = new Random();

  public int getRandom() {
    return list.get(random.nextInt(list.size()));
  }

  public static void main(String[] args) {

    RandomizedSet randomizedSet = new RandomizedSet();
    System.out.println(randomizedSet.insert(1));
    System.out.println(randomizedSet.remove(2));

    System.out.println(randomizedSet.insert(2));
    System.out.println(randomizedSet.getRandom());

    System.out.println(randomizedSet.remove(1));
    System.out.println(randomizedSet.insert(2));

    System.out.println(randomizedSet.getRandom());
  }
}
