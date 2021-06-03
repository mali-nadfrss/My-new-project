package com.mali.ds.trees.bt;

import com.mali.ds.trees.bst.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class KthAncestor {

  public static int kthAncestor(Node root, int n, int k, int node) {
    // Write your code here
    int[] arr = new int[n];
    if (root == null) {
      return -1;
    }
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    int i = 0;
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      arr[i] = current.data;
      if (current.left != null) queue.add(current.left);
      if (current.right != null) queue.add(current.right);
      if (current.data == node) {
        break;
      }
      i++;
    }
    while (k > 0) {
      i = i / 2;
      k--;
    }
    return i >= 0 ? arr[i] : -1;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    int k = 2;
    int node = 5;

    // print kth ancestor of given node
    System.out.println(kthAncestor(root,5,k,node));
  }
}
