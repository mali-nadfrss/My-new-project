package com.mali.ds.bst;

/* https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1# */
public class LCA {

    Node lowestCommonAncestor(Node root, int n1, int n2)
    {
        if(root == null){
            return null;
        } else if(n1 > root.data && n2 > root.data){
            return lowestCommonAncestor(root.right, n1, n2);
        } else if(n1 < root.data && n2 < root.data){
            return lowestCommonAncestor(root.left, n1, n2);
        } else if((n1 >= root.data && n2 <= root.data)
                || (n1 <= root.data && n2 >= root.data) ){
            return root;
        }
        return root;

    }
}
