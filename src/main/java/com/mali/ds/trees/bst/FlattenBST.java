package com.mali.ds.trees.bst;

import java.util.Stack;

/* https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/951220/Java-Recursive-Solution */
public class FlattenBST {

  /* https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
   * medium */

  public static void flatten2(Node root){

    Stack<Node> stack = new Stack<>();


    if (root.right != null)stack.add(root.right);
    if (root.left != null)stack.add(root.left);

    while(!stack.isEmpty()){
      Node cur = stack.pop();
      if (cur.right != null)stack.add(cur.right);
      if (cur.left != null)stack.add(cur.left);
      root.right = cur;
      root.left = null;
      root = root.right;
    }

  }


  public static void flatten1(Node root) {
    if (root == null) return;
    recursive(root);
    root.right = temp.right;
    root.left = temp.left;
  }

  static Node ans;
  static Node temp;

  static void recursive(Node root) {

    if (root == null) return;
    Node temp1  = new Node(root.data);
    if(ans == null){
      temp = temp1;
      ans = temp1;
    }else{
      ans.right = temp1;
      ans = ans.right;
    }
    recursive(root.left);
    recursive(root.right);
  }

  public static void flatten(Node root) {
    if (root == null || (root.left == null && root.right == null)) {
      return;
    }

    if (root.left != null) {
      flatten(root.left);
      Node temp = root.right;
      root.right = root.left;
      root.left = null;
      Node cur = root.right;
      while (cur.right != null) {
        cur = cur.right;
      }
      cur.right = temp;
    }
    flatten(root.right);
  }

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();

    tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(60);
    tree.insert(80);
    flatten2(tree.root);
    System.out.println(tree.root);
  }
}
