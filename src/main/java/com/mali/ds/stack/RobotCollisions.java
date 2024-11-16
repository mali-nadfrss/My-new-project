package com.mali.ds.stack;

import java.util.*;

/* https://leetcode.com/problems/robot-collisions/description/ */
public class RobotCollisions {

  static class Pair {

    int pos;
    int h;
    char dir;

    Pair(int pos, int h, char dir) {
      this.pos = pos;
      this.h = h;
      this.dir = dir;
    }
  }

  public static List<Integer> survivedRobotsHealths(
      int[] positions, int[] healths, String directions) {

    List<Pair> pairs = new ArrayList<>();
    for (int i = 0; i < positions.length; i++) {
      pairs.add(new Pair(positions[i], healths[i], directions.charAt(i)));
    }
    pairs.sort(Comparator.comparingInt(o -> o.pos));
    LinkedList<Pair> q = new LinkedList<>();
    q.addAll(pairs);
    while (true) {
      LinkedList<Pair> tq = new LinkedList<>();
      Set<Character> set = new HashSet<>();
      while (!q.isEmpty()) {
        if (tq.isEmpty()) {
          tq.add(q.poll());
          set.add(tq.peek().dir);
        } else {
          if (q.peek().dir == 'L' && tq.peekLast().dir == 'R') {
            if (q.peek().h > tq.peekLast().h) {
              tq.pollLast();
              q.peek().h = q.peek().h-1;
            } else if (q.peek().h == tq.peekLast().h) {
              tq.pollLast();
              q.poll();
            } else {
              q.poll();
              tq.peekLast().h = tq.peekLast().h-1;
            }
          } else {
            tq.add(q.poll());
            set.add(tq.peek().dir);
          }
        }
      }
      q = tq;
      if (set.size() <= 1) break;
    }

    List<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    while (!q.isEmpty()) {
      map.put(q.peek().pos, q.poll().h);
    }
    for (int i = 0; i < positions.length; i++) {
      if (map.get(positions[i]) != null) {
        ans.add(map.get(positions[i]));
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] positions = {3, 5, 2, 6}, healths = {10, 10, 15, 12};
    String directions = "RLRL";

    System.out.println(survivedRobotsHealths(positions, healths, directions));
  }
}
