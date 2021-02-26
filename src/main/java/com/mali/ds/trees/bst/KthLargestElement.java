package com.mali.ds.trees.bst;

import java.util.ArrayList;

/* https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1 */
public class KthLargestElement {

    ArrayList<Integer> a = new ArrayList();
    public int sol(Node root, int k){
        traverse(root);
        return a.get(a.size()-k);
    }

    public void traverse(Node root){
        if (root == null) {
            return;
        }
        traverse(root.left);
        a.add(root.data);
        traverse(root.right);
    }


    public static void main(String[] args) {

    }
}
