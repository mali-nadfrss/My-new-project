package com.mali.ds.graph.topo;

import java.util.*;

/* https://leetcode.com/problems/course-schedule-iv/description/ */
public class CourseScheduleIV {

  public static List<Boolean> checkIfPrerequisite(
      int numCourses, int[][] prerequisites, int[][] queries) {
    int n = numCourses;
    int[] deg = new int[n];
    List<Integer>[] graph = new List[n];
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
      map.put(i, new HashSet<>());
      map.get(i).add(i);
    }

    for (int[] prereq : prerequisites) {
      graph[prereq[0]].add(prereq[1]);
      deg[prereq[1]]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (deg[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int current = queue.poll();
      for (int child : graph[current]) {
        map.get(child).addAll(map.get(current));
        deg[child]--;
        if (deg[child] == 0) {
          queue.add(child);
        }
      }
    }

    List<Boolean> ans = new ArrayList<>();
    for (int[] query : queries) {
      if (map.get(query[1]).contains(query[0])) {
        ans.add(true);
      } else {
        ans.add(false);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int numCourses = 3;
    int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}};
    int[][] queries = {{1, 0}, {1, 2}};
    checkIfPrerequisite(numCourses, prerequisites, queries);
  }
}
