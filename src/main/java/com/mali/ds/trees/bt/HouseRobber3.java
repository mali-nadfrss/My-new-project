package com.mali.ds.trees.bt;

import com.mali.ds.trees.bst.Node;

import java.util.Arrays;
import java.util.Map;

/*
https://leetcode.com/problems/house-robber-iii/
medium
 */
public class HouseRobber3 {
  public int rob(Node root, Map<Node, Integer> map) {
    if (root == null) {
      return 0;
    }
    if (map.containsKey(root)) {
      return map.get(root);
    }
    int val = 0;
    if (root.left != null) {
      val = val + rob(root.left.left, map) + rob(root.left.right, map);
    }
    if (root.right != null) {
      val = val + rob(root.right.right, map) + rob(root.right.left, map);
    }
    val = Math.max(val + root.data, rob(root.left, map) + rob(root.right, map));
    map.put(root, val);
    return val;
  }

  private static int[] robSub(Node root) {
    if (root == null) {
      return new int[2];
    }
    int[] left = robSub(root.left);
    int[] right = robSub(root.right);

    int[] res = new int[2];
    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    res[1] = root.data + left[0] + right[0];
    return res;
  }

  public static void main(String[] args) {
    Node root = new Node(3);
    root.right = new Node(5);
    root.left = new Node(4);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.right = new Node(1);
    System.out.println(Arrays.toString(robSub(root)));
  }
}
