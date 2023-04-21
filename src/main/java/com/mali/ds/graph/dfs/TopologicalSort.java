package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

  static void topoSort(List<List<Integer>> graph, int V) {

    Stack<Integer> stack = new Stack<>();
    int[] vis = new int[V];

    for (int i = 0; i < V; i++) {
      dfs(vis, stack, graph, i);
    }

    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  static void dfs(int[] vis, Stack<Integer> stack, List<List<Integer>> graph, int current) {
    if (vis[current] == 1) return;
    vis[current] = 1;
    for (int edge : graph.get(current)) {
      dfs(vis, stack, graph, edge);
    }
    stack.add(current);
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
