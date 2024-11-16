package com.mali.ds.graph.unionFind;

import java.util.*;

/* https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/ */
public class MostStonesRemovedwithSameRoworColumn {
  // todo

  class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int removeStones(int[][] stones) {
    Map<Integer, List<Pair>> map = new HashMap<>();
    Map<Pair, Pair> parents = new HashMap<>();
    for (int[] i : stones) {
      Pair p = new Pair(i[0], i[1]);
      map.putIfAbsent(i[0], new ArrayList<>());
      map.get(i[0]).add(p);
      if (p.x != p.y) {
        map.putIfAbsent(i[1], new ArrayList<>());
        map.get(i[1]).add(p);
      }
      parents.put(p, p);
    }

    for (Map.Entry<Integer, List<Pair>> entry : map.entrySet()) {
      List<Pair> l = entry.getValue();
      for (int i = 1; i < l.size(); i++) {
        unionFind(l.get(i - 1), l.get(i), parents);
      }
    }

    Set<Pair> set = new HashSet<>();

    for (Pair p : parents.values()) {
      set.add(p);
    }
    return stones.length - set.size();
  }

  Pair findParent(Map<Pair, Pair> parents, Pair p) {
    if (parents.get(p) != p) {
      parents.put(p, findParent(parents, parents.get(p)));
    }
    return p;
  }

  void unionFind(Pair p, Pair q, Map<Pair, Pair> parents) {

    Pair pp = findParent(parents, p);
    Pair qp = findParent(parents, q);

    if ((pp.x == qp.x && pp.y <= qp.y) || (pp.y == qp.y && pp.x <= qp.y)) {
      parents.put(qp, pp);
    } else {
      parents.put(pp, qp);
    }
  }

  public static void main(String[] args) {
    MostStonesRemovedwithSameRoworColumn m = new MostStonesRemovedwithSameRoworColumn();
    int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
    int[][] stones1 = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
    System.out.println(m.removeStones(stones));
    System.out.println(m.removeStones(stones1));
  }



}
