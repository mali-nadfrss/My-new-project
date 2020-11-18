package com.mali.ds.bst;

/* https://practice.geeksforgeeks.org/problems/minimum-element-in-bst/1 */
public class FindMinAndMax {

    static void min(Node n){
        if (n.left == null){
            System.out.println(n.data);
        }
        else{
            min(n.left);
        }

    }
    static void max(Node n){
        if (n.right == null){
            System.out.println(n.data);
        }
        else{
            max(n.right);
        }

    }

    public static void main(String[] args) {
     Node n =  new Node(5);
     n.right = new Node(6);
     n.right.right = new Node(7);
     n.left= new Node(4);
     n.left.left = new Node(3);
     n.left.left = new Node(1);
     min(n);
     max(n);
    }

}
