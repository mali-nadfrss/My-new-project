package com.mali.ds;

import java.util.Iterator;

public class DFS {

    public static void dfsUtil(Graph g , boolean[] visited, int i){
        visited[i] = true;
        System.out.println("i:"+ i);
        Iterator<Integer> it = g.getArr(i).iterator();
        while(it.hasNext()){
            int j = it.next();
            if (!visited[j])
            dfsUtil(g,visited,j);
        }
    }

    public static void dfs(Graph g){
        boolean[] visited = new boolean[g.getVertices()];
        for (int i = 0 ; i < g.getVertices() ; i++){
            if (! visited[i])
            dfsUtil(g, visited, i);
        }
    }
    public static void main(String args[]) throws Exception {
        Graph g = new Graph(6);
        g.add(0,1);
        g.add(0,2);
        g.add(0,3);
        g.add(3,2);
        g.add(4,5);
        dfs(g);
    }
}
