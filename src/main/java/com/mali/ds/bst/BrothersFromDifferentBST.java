package com.mali.ds.bst;

import java.util.HashSet;
import java.util.Set;

public class BrothersFromDifferentBST {

    static Set<Integer> s = new HashSet<>();
    static int ans = 0;
    public static int countPairs(Node root1, Node root2, int x)
    {
        // your code here
        s = new HashSet<>();
        ans = 0;
        inOrder(root1,root2,x);
        inOrder(root2,root1, x);
        return ans/2;
    }

    public static void find(Node root, int x){
        if (root == null){
        } else if (root.data > x){
            find(root.left,x);
        }else if (root.data < x){
            find(root.right,x);
        }else{
            ans++;
        }
    }
    public static void inOrder(Node root1, Node root2, int x){
        if(root1== null){
            return;
        }
        inOrder(root1.left,root2, x);
        find(root2, x- root1.data);
        inOrder(root1.right,root2, x);

    }

}
