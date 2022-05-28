package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* https://leetcode.com/problems/accounts-merge/
* medium */
public class AccountsMerge {

    //todo
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans  = new ArrayList<>();
        boolean[] visited = new boolean[accounts.size()];

        Map<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < accounts.size(); i++) {
      for (String k : accounts.get(i)) {
          if (k.contains(".com")){
              map.computeIfAbsent(k, v ->new ArrayList<>());
              map.get(k).add(i);
          }
      }
    }
return ans;
    }


    void dfs(List<List<String>> accounts, int[] parent,Map<String, List<Integer>> map
    , boolean[] visited, int i){
        if (visited[i]){
            return;
        }
    for (int j = 0; j < accounts.get(i).toArray().length; j++) {
      parent[j] = i;
    }
    }
}
