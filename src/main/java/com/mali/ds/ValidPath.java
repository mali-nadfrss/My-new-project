package com.mali.ds;

import java.util.ArrayList;

public class ValidPath {

  boolean isValid(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
    int visited[][] = new int[A][B];
    for (int i = 0; i < A; i++) {
      for (int j = 0; j < B; j++) {
        visited[i][j] = 0;
      }
    }
    for (int i = 0; i < E.size(); i++) {
      visited[E.get(i)][F.get(i)] = 1;
      for (int j = 0; j <= D; j++) {
        int k = E.get(i)+j;
        int l = F.get(i)+j;
        if (k-1 >= 0 && l-1 >= 0 && k-1 <= A  && l-1 <= B){
          visited[k-1][l-1] = 1;
        }
        if (k-1 >= 0 && l >= 0 && k-1 <= A  && l <= B){
          visited[k-1][l] = 1;
        }
        if (k-1 >= 0 && l+1 >= 0 && k-1 <= A  && l+1 <= B){
          visited[k-1][l+1] = 1;
        }
        if ( k >= 0 && l-1 >= 0 && k <= A  && l-1 <= B ){
          visited[k][l-1] = 1;
        }
        if (k >= 0 && l+1 >= 0 && k <= A  && l+1<= B ){
          visited[k][l+1] = 1;
        }
        if (k+1 >= 0 && l-1 >= 0 && k+1 <= A  && l-1 <= B ){
          visited[k+1][l-1] = 1;
        }
        if (k+1 >= 0 && l >= 0 && k+1 <= A  && l <= B ){
          visited[k+1][l] = 1;
        }
        if (k+1 >= 0 && l+1 >= 0 && k+1 <= A  && l+1 <= B ){
          visited[k+1][l+1] = 1;
        }
      }
    }
    boolean[][] v = new boolean[A][B];
    return tryDfs(visited,A, B, 0, 0, v );
  }

  boolean tryDfs(int[][] visited, int A, int B, int k, int l, boolean[][] v){

    if (A== k && B == l){
      return true;
    }

    v[k][l] = true;

    if (k-1 >= 0 && l-1 >= 0 && k-1 <= A  && l-1 <= B){
      visited[k-1][l-1] = 1;
    }
    if (k-1 >= 0 && l >= 0 && k-1 <= A  && l <= B){
      visited[k-1][l] = 1;
    }
    if (k-1 >= 0 && l+1 >= 0 && k-1 <= A  && l+1 <= B){
      visited[k-1][l+1] = 1;
    }
    if ( k >= 0 && l-1 >= 0 && k <= A  && l-1 <= B ){
      visited[k][l-1] = 1;
    }
    if (k >= 0 && l+1 >= 0 && k <= A  && l+1<= B ){
      visited[k][l+1] = 1;
    }
    if (k+1 >= 0 && l-1 >= 0 && k+1 <= A  && l-1 <= B ){
      visited[k+1][l-1] = 1;
    }
    if (k+1 >= 0 && l >= 0 && k+1 <= A  && l <= B ){
      visited[k+1][l] = 1;
    }
    if (k+1 >= 0 && l+1 >= 0 && k+1 <= A  && l+1 <= B ){
      visited[k+1][l+1] = 1;
    }

    return false;
  }

  public static void main(String[] args) throws Exception {}
}
