package com.mali.ds.trees.bt;

import com.mali.ds.trees.bst.Node;

/** easy 2 https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1 */
public class LeavesInBT {
  int countLeaves(Node node) {
    return node == null
        ? 0
        : node.left == null && node.right == null
            ? 1
            : countLeaves(node.left) + countLeaves(node.right);
  }
}
