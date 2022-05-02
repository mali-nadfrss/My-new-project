package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/keys-and-rooms/
 * medium */
public class KeysAndRooms {
  public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int n = rooms.size();
    int[] room = new int[n];
    dfs(rooms, room, 0);
    for (int i = 0; i < n ; i++) {
      if (room[i] == 0) {
        return false;
      }
    }
    return true;
  }

  static void dfs(List<List<Integer>> rooms, int[] room, int i) {
    room[i] = 1;
    for (int j : rooms.get(i)) {
      if (room[j] == 0) {
        dfs(rooms, room, j);
      }
    }
  }

  public static void main(String[] args) {
   // int[][] days = {{1, 3}, {3, 0, 1}, {2}, {0}};
    List<List<Integer>> main = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(3);
    main.add(list);

    list = new ArrayList<>();
    list.add(3);
    list.add(0);
    list.add(1);
    main.add(list);

    list = new ArrayList<>();
    list.add(2);
    main.add(list);

    list = new ArrayList<>();
    list.add(0);
    main.add(list);

    System.out.println(canVisitAllRooms(main));
  }
}
