package com.mali.ds.algorithms;

import java.util.*;

/* https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/ */
public class Kahns {

  public static void topoSort(List<List<Integer>> graph, int V) {

    int[] indegree = new int[V];

    for (List<Integer> adj : graph) {
      for (int node : adj) {
        indegree[node]++;
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    int cnt = 0;
    Stack<Integer> stack = new Stack<>();
    while (!queue.isEmpty()) {
      int node = queue.poll();
      stack.add(node);
      for (int child : graph.get(node)) {
        indegree[child]--;
        if (indegree[child] == 0) {
          queue.add(child);
        }
      }
      cnt++;
    }

    if (cnt != V) {
      System.out.println("cycle exists cant find topo order");
    } else {
      System.out.println("---------topo order--------- ");
      while (!stack.isEmpty()) {
        System.out.println(stack.pop());
      }
    }
  }

  public static void main(String[] args) {

    int V = 6;
    List<List<Integer>> graph = new ArrayList<>(V);

    // Vertex - 0
    ArrayList<Integer> neighbors = new ArrayList<Integer>();
    graph.add(neighbors);

    // Vertex - 1
    neighbors = new ArrayList<Integer>();
    graph.add(neighbors);

    // Vertex - 2
    neighbors = new ArrayList<Integer>();
    neighbors.add(3);
    graph.add(neighbors);

    // Vertex - 3
    neighbors = new ArrayList<Integer>();
    neighbors.add(1);
    graph.add(neighbors);

    // Vertex - 4
    neighbors = new ArrayList<Integer>();
    neighbors.add(0);
    neighbors.add(1);
    graph.add(neighbors);

    // Vertex - 5
    neighbors = new ArrayList<Integer>();
    neighbors.add(0);
    neighbors.add(2);
    graph.add(neighbors);

    topoSort(graph, V);
  }
}
