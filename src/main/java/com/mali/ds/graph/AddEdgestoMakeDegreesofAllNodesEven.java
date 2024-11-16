package com.mali.ds.graph;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-324/problems/add-edges-to-make-degrees-of-all-nodes-even/ */
public class AddEdgestoMakeDegreesofAllNodesEven {

  public static boolean isPossible(int n, List<List<Integer>> edges) {

    Set<Integer> all = new HashSet<>();
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (List<Integer> l : edges) {
      graph.putIfAbsent(l.get(0), new HashSet<>());
      graph.putIfAbsent(l.get(1), new HashSet<>());
      graph.get(l.get(0)).add(l.get(1));
      graph.get(l.get(1)).add(l.get(0));
      all.add(l.get(0));
      all.add(l.get(1));
    }

    int sum = 0;
    Map<Integer, Set<Integer>> result = new HashMap<>();
    for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {

      if (entry.getValue().size() % 2 != 0) {
        result.put(entry.getKey(), entry.getValue());
      }
    }

    if (result.size() > 5 || result.size() % 2 != 0) return false;

    List<Integer> keys = new ArrayList<>();
    for (Map.Entry<Integer, Set<Integer>> entry : result.entrySet()) {
      keys.add(entry.getKey());
    }
    if (result.size() == 2) {
      if (result.get(keys.get(0)).contains(keys.get(1))
          || result.get(keys.get(1)).contains(keys.get(0))) {
        // check for all
        return checkForAll(keys, graph);
      } else {
        return true;
      }
    }
    // todo check for 4 size as well
    return true;
  }

  static boolean checkForAll(List<Integer> keys, Map<Integer, Set<Integer>> graph) {
    for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
      if (!entry.getKey().equals(keys.get(0))
          && !entry.getKey().equals(keys.get(1))
          && !entry.getValue().contains(keys.get(0))
          && !entry.getValue().contains(keys.get(1))) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {

    // [[1,2],[2,3],[3,4],[4,2],[1,4],[2,5]]
    List<List<Integer>> list = new ArrayList<>();
    int[][] arr = {
      {2, 19}, {16, 17}, {8, 14}, {2, 16}, {12, 20}, {12, 14}, {16, 18}, {15, 16}, {10, 21}, {3, 5},
      {13, 18}, {17, 20}, {14, 17}, {9, 12}, {5, 15}, {5, 6}, {3, 7}, {2, 21}, {10, 13}, {8, 16},
      {7, 18}, {4, 6}, {9, 1}, {13, 21}, {18, 20}, {7, 14}, {4, 19}, {5, 8}, {3, 11}, {11, 1},
      {7, 12}, {4, 7}, {3, 16}, {13, 17}, {17, 19}, {9, 13}, {7, 19}, {10, 16}, {4, 13}, {4, 5},
      {2, 15}, {12, 19}, {11, 16}, {2, 9}, {11, 17}, {17, 1}, {16, 21}, {4, 10}, {10, 14}, {14, 16},
      {4, 1}, {13, 20}, {5, 20}, {4, 14}, {4, 21}, {10, 20}, {2, 14}, {8, 15}, {4, 8}, {6, 19},
      {15, 1}, {19, 1}, {8, 19}, {15, 21}, {3, 12}, {11, 18}, {9, 17}, {18, 19}, {7, 21}, {3, 21},
      {16, 19}, {11, 15}, {5, 1}, {8, 17}, {3, 15}, {8, 1}, {10, 19}, {3, 8}, {6, 16}, {2, 8},
      {5, 18}, {11, 13}, {11, 20}, {14, 21}, {6, 20}, {4, 20}, {12, 13}, {5, 12}, {10, 11}, {9, 15},
      {3, 19}, {9, 20}, {14, 18}, {21, 1}, {13, 19}, {8, 21}, {2, 13}, {3, 10}, {9, 18}, {19, 21},
      {6, 7}, {3, 18}, {2, 18}, {6, 14}, {3, 17}, {5, 21}, {14, 20}, {8, 9}, {16, 1}, {3, 4},
      {13, 1}, {5, 9}, {4, 15}, {17, 21}, {20, 21}, {2, 17}, {13, 14}, {11, 14}, {9, 16}, {10, 18},
      {6, 15}, {6, 12}, {3, 13}, {5, 11}, {6, 1}, {12, 17}, {8, 10}, {5, 10}, {8, 18}, {4, 12},
      {10, 1}, {6, 13}, {4, 18}, {7, 20}, {7, 16}, {2, 6}, {12, 21}, {4, 17}, {15, 18}, {13, 16},
      {15, 20}, {7, 10}, {6, 10}, {2, 20}, {7, 15}, {18, 1}, {12, 1}, {3, 20}, {7, 1}, {14, 15},
      {4, 9}, {11, 19}, {7, 9}, {5, 17}, {18, 21}, {6, 21}, {8, 11}, {6, 17}, {3, 14}, {7, 11},
      {5, 7}, {7, 13}, {6, 8}, {6, 9}, {10, 12}, {5, 16}, {2, 4}, {17, 18}, {9, 11}, {12, 16},
      {3, 6}, {12, 18}, {3, 9}, {11, 12}, {14, 19}, {10, 15}, {5, 13}, {8, 13}, {15, 17}, {2, 10},
      {11, 21}, {20, 1}, {6, 18}, {2, 12}, {19, 20}, {6, 11}, {8, 12}, {2, 3}, {12, 15}, {2, 11},
      {9, 10}, {7, 17}, {9, 19}, {13, 15}, {7, 8}, {4, 11}, {2, 5}, {5, 19}, {16, 20}, {15, 19},
      {9, 14}, {14, 1}, {10, 17}, {9, 21}, {2, 7}, {8, 20}, {5, 14}, {4, 16}
    };
    int[][] arr1 = {{1, 2}, {3, 4}};
    for (int[] i : arr1) {
      List<Integer> l = new ArrayList<>();
      l.add(i[0]);
      l.add(i[1]);
      list.add(l);
    }
    System.out.println(isPossible(2, list));
  }
}
