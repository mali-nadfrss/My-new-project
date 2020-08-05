package com.mali.ds;

import java.util.Iterator;

public class IslandCluster {
    public static void dfsUtil(Graph g , boolean[] visited, int i){
        visited[i] = true;
        Iterator<Integer> it = g.getArr(i).iterator();
        while(it.hasNext()){
            int j = it.next();
            if (!visited[j])
                dfsUtil(g,visited,j);
        }
    }

    public static int dfs(Graph g){
        boolean[] visited = new boolean[g.getVertices()];
        int ans = 0;
        for (int i = 0 ; i < g.getVertices() ; i++){
            if (! visited[i]){
                ans++;
                dfsUtil(g, visited, i);
            }
        }
        return ans;
    }
    public static void main(String args[]) throws Exception {
        Graph g = new Graph(6);
        g.add(0,1);
        g.add(0,2);
        g.add(0,3);
        g.add(3,2);
        g.add(4,5);
        System.out.println(dfs(g));
    }
}

