package practice;

import java.util.*;

public class Solution {

  static final int[] points = {3, 2, 1};
  private static Map<String, List<String>> votesMap;
  private static Map<String, Integer> votesCount;

  private static List<String> findWinner(List<Vote> votes) {

    votesCount = new HashMap<>();
    for (Vote vote : votes) {
      List<String> candidates = vote.getCandidates();
      for (int i = 0; i < candidates.size(); i++) {
        votesCount.put(
            candidates.get(i), votesCount.getOrDefault(candidates.get(i), 0) + points[i]);
      }
    }
    List<String> result = new ArrayList<>();
    for (String candidate : votesCount.keySet()) {
      result.add(candidate);
    }
    Collections.sort(result, (a, b) -> votesCount.get(b).compareTo(votesCount.get(a)));

    return result;
  }

  public static void main(String[] args) {
    List<Vote> votes = new ArrayList<>();
    List<String> v = new ArrayList<>();
    v.add("a");
    v.add("b");
    v.add("c");
    votes.add(new Vote(v));
    v = new ArrayList<>();
    v.add("b");
    v.add("a");
    v.add("c");
    votes.add(new Vote(v));
    v = new ArrayList<>();
    v.add("a");
    v.add("c");
    v.add("b");
    votes.add(new Vote(v));
    System.out.println(findWinner(votes));
  }
}
