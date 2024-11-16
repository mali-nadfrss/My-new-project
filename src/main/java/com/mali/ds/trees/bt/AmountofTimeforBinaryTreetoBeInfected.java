package com.mali.ds.trees.bt;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 * medium */
public class AmountofTimeforBinaryTreetoBeInfected {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static int amountOfTime(TreeNode root, int start) {

    int[][] graph = new int[100001][3];
    graph(graph, root, -1);
    Queue<Integer> aq = new LinkedList<>();
    aq.add(start);
    int ans = -1;
    boolean[] visited = new boolean[100001];
    while (!aq.isEmpty()) {
      int k = aq.size();
      for (int i = 0; i < k; i++) {
        int val = aq.poll();
        if (visited[val]) continue;
        visited[val] = true;
        if (graph[val][0] != -1 && !visited[graph[val][0]]) {
          aq.add(graph[val][0]);
        }
        if (graph[val][1] != -1&& !visited[graph[val][1]]) {
          aq.add(graph[val][1]);
        }
        if (graph[val][2] != -1 && !visited[graph[val][2]]) {
          aq.add(graph[val][2]);
        }
      }
      ans++;
    }
    return ans;
  }

  static void graph(int[][] graph, TreeNode node, int parent){
    if (node == null) return;
    if (parent != -1){
      graph[node.val][0] = parent;
    } else graph[node.val][0] = -1;
    if (node.left != null){
      graph[node.val][1] = node.left.val;
      graph(graph, node.left, node.val);
    }else graph[node.val][1] = -1;
    if (node.right != null){
      graph[node.val][2] = node.right.val;
      graph(graph, node.right, node.val);
    }else graph[node.val][2] = -1;
  }

  public static void main(String[] args) {

    TreeNode head = new TreeNode(1);
    head.left = new TreeNode(5);
    head.right = new TreeNode(3);
    head.left.right = new TreeNode(4);
    head.right.left = new TreeNode(10);

    head.left.right.left = new TreeNode(9);
    head.left.right.right = new TreeNode(2);

    head.right.left = new TreeNode(10);
    head.right.right = new TreeNode(6);
    TreeNode head1 = new TreeNode(5);
    head1.left = new TreeNode(2);
    head1.right = new TreeNode(3);
    head1.left.left = new TreeNode(4);
    head1.left.left.left = new TreeNode(1);

    TreeNode head2 = new TreeNode(1);

    System.out.println(amountOfTime(head2, 1));
  }
}
