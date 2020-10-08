package com.mali.ds.graph;

import java.util.Iterator;

public class RoadsAndLibraries {
    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) throws Exception {

        Graph g = new Graph(n);
        int road = 0;
        for (int i = 0; i < cities.length; i++) {
            g.add(cities[i][0], cities[i][1]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                road = dfsUtil(g, visited, i, road);
            }
        }
        if(c_road+1 > c_lib){
            return road*c_road;
        }
        return c_lib*n;
    }

    static int dfsUtil(Graph g , boolean[] visited, int i, int road){
        visited[i] = true;
        road++;
        Iterator<Integer> it = g.getArr(i).iterator();
        while(it.hasNext()){
            int j = it.next();
            if (!visited[j]){
                dfsUtil(g, visited, j, road);
            }
        }
        return road;
    }


    public static void main(String[] args) throws Exception {
        int[][] i = new int[3][2];
        i[0][0] = 0;
        i[0][1] = 1;
        i[1][0] = 2;
        i[1][1] = 0;
        i[2][0] = 1;
        i[2][1] = 2;
        System.out.println(roadsAndLibraries(3, 2, 1, i));
    }
}
