package com.mali.ds.graph.dfs;

public class IslandClusterPart2 {

  public static void dfs(int i, int j, int[][] data, boolean[][] visited){
    visited[i][j] = true;
    if (i-1 >= 0 && j-1 >= 0 && data[i-1][j-1] == 1 && !visited[i-1][j-1]){
      dfs(i-1, j-1, data, visited);
    }
    if (i-1 >= 0 && j <= 3  && data[i-1][j] == 1 && !visited[i-1][j]){
      dfs(i-1, j, data, visited);
    }
    if (i-1 >= 0  &&  j+1 <= 3 && data[i-1][j+1] == 1 && !visited[i-1][j+1]){
      dfs(i-1, j+1, data, visited);
    }
    if ( i <= 3 && j-1 >= 0 && data[i][j-1] == 1 && !visited[i][j-1]){
      dfs(i, j-1, data, visited);
    }
    if (i <= 3 && j+1 <= 3 && data[i][j+1] == 1 && !visited[i][j+1]){
      dfs(i, j+1, data, visited);
    }
    if (i+1 <= 3 && j-1 >= 0 && data[i+1][j-1] == 1 && !visited[i+1][j-1]){
      dfs(i+1, j-1, data, visited);
    }
    if (i+1 <= 3 && j <= 3 && data[i+1][j] == 1 && !visited[i+1][j]){
      dfs(i+1, j, data, visited);
    }
    if (i+1 <= 3 && j+1 <= 3 && data[i+1][j+1] == 1 && !visited[i+1][j+1]){
      dfs(i+1, j+1, data, visited);
    }

  }

  public static void main(String[] args) throws Exception {
    int n = 4;
    int m = 4;
    int[][] data = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        data[i][j] = 0;
      }
    }

    data[0][0] = 1;
    data[1][1] = 1;
    data[2][0] = 1;
    data[3][3] = 1;
    data[0][3] = 1;
    data[3][2] = 1;

    int ans = 0;

    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && data[i][j] == 1){
          ans++;
          System.out.println("i:"+1+": j:"+j);
          dfs(i,j,data, visited);
        }
      }
    }

    System.out.println(ans);
  }
}
