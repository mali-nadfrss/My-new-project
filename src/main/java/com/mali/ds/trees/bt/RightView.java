package com.mali.ds.trees.bt;

import com.mali.ds.trees.bst.Node;

import java.util.*;

/** https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1 easy */
public class RightView {

  class DistanceNode {
    Node node;
    int distance;

    DistanceNode(int distance, Node node) {
      this.distance = distance;
      this.node = node;
    }
  }

  ArrayList<Integer> rightView(Node node) {
    // add code here.

    if (node == null) {
      return new ArrayList<>();
    }
    Queue<DistanceNode> queue = new ArrayDeque<>();
    queue.add(new DistanceNode(0, node));
    Map<Integer, Integer> map = new TreeMap<>();
    map.put(0, node.data);
    while (!queue.isEmpty()) {
      DistanceNode distanceNode = queue.poll();
      if (!map.containsKey(distanceNode.distance)) {
        map.put(distanceNode.distance, distanceNode.node.data);
      }
      if (distanceNode.node.right != null) {
        queue.add(new DistanceNode(distanceNode.distance + 1, distanceNode.node.right));
      }
      if (distanceNode.node.left != null) {
        queue.add(new DistanceNode(distanceNode.distance + 1, distanceNode.node.left));
      }
    }
    ArrayList<Integer> ans = new ArrayList<>();
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      ans.add(e.getValue());
    }
    return ans;
  }
}
