package com.mali.ds;

import java.util.LinkedList;

public class Graph {

  private int vertices;
  private LinkedList<Integer>[] arr;

  public Graph(int vertices) {
    this.vertices = vertices;
    arr = new LinkedList[vertices];
    for (int i = 0; i < vertices; i++) {
      arr[i] = new LinkedList();
    }
  }

  public void add(int vertex, int d) throws Exception {
    if(vertex >= vertices){
      throw new Exception("vertex not allowed");
    }
    arr[vertex].add(d);
  }

  public int getVertices() {
    return vertices;
  }

  public LinkedList getArr(int i ) {
    return arr[i];
  }
}
