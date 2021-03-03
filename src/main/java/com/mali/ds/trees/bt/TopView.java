package com.mali.ds.trees.bt;

import com.mali.ds.trees.bst.Node;

import java.util.*;

public class TopView {

  static class DistanceNode {
    Node node;
    int distance;

    DistanceNode(Node node, int distance) {
      this.node = node;
      this.distance = distance;
    }
  }

  static void topView(Node head) {
    Queue<DistanceNode> queue = new ArrayDeque<>();
    DistanceNode head1 = new DistanceNode(head, 0);
    queue.add(head1);
    Map<Integer, Integer> map = new TreeMap<>();
    while (!queue.isEmpty()) {
      DistanceNode currentnode = queue.poll();
      if (!map.containsKey(currentnode.distance)) {
        map.put(currentnode.distance, currentnode.node.data);
      }

      if (currentnode.node.left != null) {
        DistanceNode leftNode = new DistanceNode(currentnode.node.left, currentnode.distance - 1);
        queue.add(leftNode);
      }

      if (currentnode.node.right != null) {
        DistanceNode rightNode = new DistanceNode(currentnode.node.right, currentnode.distance + 1);
        queue.add(rightNode);
      }
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.print(entry.getValue() + " ");
    }
  }

  // Driver Program to test above functions
  public static void main(String[] args) {
    /* Create following Binary Tree
        1
    / \
    2 3
    \
        4
        \
        5
        \
            6*/
    Node tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(3);
    tree.left.right = new Node(4);
    tree.left.right.right = new Node(5);
    tree.left.right.right.right = new Node(6);
    System.out.println("Following are nodes in top view of Binary Tree");
    topView(tree);
  }
}
