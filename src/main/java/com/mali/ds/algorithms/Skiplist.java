package com.mali.ds.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* https://www.geeksforgeeks.org/skip-list/ */
/* https://leetcode.com/problems/design-skiplist/description/ */
/* Hard */
public class Skiplist {
  // multiple levels for searching, insertion will be faster

  List<LinkedList> levels;

  public Skiplist() {
    this.levels = new ArrayList<>();
  }

  public boolean search(int target) {
    return false;
  }

  public void add(int num) {
    if (levels.get(0) == null) {}
  }

  public boolean erase(int num) {
    return false;
  }

  public static void main(String[] args) {}
}
