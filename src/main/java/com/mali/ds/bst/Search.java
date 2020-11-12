package com.mali.ds.bst;

import com.mali.ds.bt.Node;

public class Search {

    static Node find(Node root, int key){
        if (root == null){
            return null;
        }
        else if (root.data == key){
            return root;
        }
        else if (root.data > key){
            return find(root.left,key);
        }
        else {
            find(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        Node n = new Node(8);
        System.out.println(find(n,8));

    }
}
