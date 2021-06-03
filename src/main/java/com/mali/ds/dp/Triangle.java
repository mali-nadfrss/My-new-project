package com.mali.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
  public static int minimumTotal(List<List<Integer>> triangle) {

    for (int i = triangle.get(triangle.size() - 1).size() - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
      }
    }
    return triangle.get(0).get(0);
  }

  public static void main(String[] args) {
    List<List<Integer>> nums = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    temp.add(2);
    nums.add(temp);
    temp = new ArrayList<>();
    temp.add(3);
    temp.add(4);
    nums.add(temp);
    temp = new ArrayList<>();
    temp.add(6);
    temp.add(5);
    temp.add(7);
    nums.add(temp);
    temp = new ArrayList<>();
    temp.add(4);
    temp.add(1);
    temp.add(8);
    temp.add(3);
    nums.add(temp);
    System.out.println(minimumTotal(nums));
  }
}
