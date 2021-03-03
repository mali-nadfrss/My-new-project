package com.mali.ds.trees.bst;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BST2MinHeap {

    static Node convert(Node n){
        List list = new LinkedList();
        inOrder(n, list);
        Iterator iterator = list.iterator();
        preOrder(n,iterator);
        return n;
    }


    static Node inOrder(Node n , List list){
        if (n == null){
            return null;
        }
        inOrder(n.left, list);
        list.add(n.data);
        inOrder(n.right, list);
        return n;
    }

    static Node preOrder(Node n , Iterator iterator){
        if (n == null){
            return null;
        }
        n.data = (int) iterator.next();
        preOrder(n.left, iterator);
        preOrder(n.right, iterator);
        return n;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.inOrder(tree.root);
        System.out.println();
        convert(tree.root);
        tree.inOrder(tree.root);

    }
}
