package com.mali.ds.bt;

public class Node {

    public final int data;
    public Node left;
    public Node right;

    public Node(int data){
        this.data = data;
    }

    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
