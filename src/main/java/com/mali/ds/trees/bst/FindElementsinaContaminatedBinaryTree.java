package com.mali.ds.trees.bst;

import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
* medium */
public class FindElementsinaContaminatedBinaryTree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    TreeNode root;

    public FindElementsinaContaminatedBinaryTree(TreeNode root) {
        if(root != null){
            root.val = 0;
            set.add(0);
            recursion(root);}
        this.root = root;
    }

    Set<Integer> set = new HashSet<>();

    void recursion(TreeNode root){

        if(root == null) return;
        if(root.left != null){
            set.add(2*root.val+1);
            root.left.val = 2*root.val+1;
            recursion(root.left);
        }
        if(root.right != null){
            root.right.val = 2*root.val+2;
            set.add(2*root.val+2);
            recursion(root.right);
        }

    }

    public boolean find(int target) {
        return set.contains(target);
    }

    boolean recur(TreeNode root, int target){
        if (root == null) return false;
        if(root.val == target) return true;
        else if(root.val > target) return recur(root.left, target);
        else return recur(root.right, target);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.left.left =  new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        root.right = new TreeNode(-1);
        FindElementsinaContaminatedBinaryTree a = new FindElementsinaContaminatedBinaryTree(root);
    System.out.println(a.find(1));
    }

}
