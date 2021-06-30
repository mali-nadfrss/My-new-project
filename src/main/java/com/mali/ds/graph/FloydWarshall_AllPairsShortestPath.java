package com.mali.ds.graph;

/*
https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
algorithms
 */
public class FloydWarshall_AllPairsShortestPath {
  final static int INF = 99999;
  static void floydWarshall(int graph[][], int V) {
    for (int k = 0; k < V; k++) {
      for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
          if (graph[i][j] > graph[i][k] + graph[k][j]) {
            graph[i][j] = graph[i][k] + graph[k][j];
          }
        }
      }
    }
    printSolution(graph, V);
  }

  static void printSolution(int dist[][], int V)
  {
    System.out.println("The following matrix shows the shortest "+
            "distances between every pair of vertices");
    for (int i=0; i<V; ++i)
    {
      for (int j=0; j<V; ++j)
      {
        if (dist[i][j]==INF)
          System.out.print("INF ");
        else
          System.out.print(dist[i][j]+"   ");
      }
      System.out.println();
    }
  }

  public static void main (String[] args)
  {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
    int graph[][] = { {0,   5,  INF, 10},
            {INF, 0,   3, INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
    };
    printSolution(graph, 4);
    floydWarshall(graph, 4);
    }

}
