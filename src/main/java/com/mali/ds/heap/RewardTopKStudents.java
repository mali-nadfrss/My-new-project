package com.mali.ds.heap;

import java.util.*;

/* https://leetcode.com/contest/biweekly-contest-94/problems/reward-top-k-students/ */
public class RewardTopKStudents {

  public static List<Integer> topStudents(
      String[] positive_feedback,
      String[] negative_feedback,
      String[] report,
      int[] student_id,
      int k) {

    Set<String> pSet = new HashSet<>();
    Set<String> nSet = new HashSet<>();
    for (String s : positive_feedback) {
      pSet.add(s);
    }
    for (String s : negative_feedback) {
      nSet.add(s);
    }

    PriorityQueue<int[]> pq =
        new PriorityQueue<>(
            (a, b) -> {
              if (a[1] == b[1]) return Integer.compare(  a[0], b[0]);
              return Integer.compare(b[1], a[1]);
            });
    for (int i = 0; i < report.length; i++) {
      String[] arr = report[i].split(" ");
      int p = 0;
      int n = 0;
      for (String s : arr) {
        if (pSet.contains(s)) {
          p++;
        }
        if (nSet.contains(s)) {
          n++;
        }
      }
      int[] j = {student_id[i], 3 * p - n};
      pq.add(j);
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < k && !pq.isEmpty(); i++) {
      ans.add(pq.poll()[0]);
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] s1 = {"smart", "brilliant", "studious"};
    String[] s2 = {"not"};
    String[] s3 = {"this student is studious", "the student is smart"};
    int[] i1 = {1, 2};
    int k = 2;
    System.out.println(topStudents(s1, s2, s3, i1, k));
  }
}
