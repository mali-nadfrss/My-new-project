package com.mali.ds.bt;

public class MaxEvenSumInBST {

    static int maxSum(Node n, int ans){

        if (n == null){
            return ans %2 == 0 ? ans : 0;
        }
        ans = ans +n.data;
        return Math.max(maxSum(n.left,ans),maxSum(n.right,ans));

    }

    public static void main(String args[]) throws Exception {
        Node n = new Node(20);
        n.left = new Node(8);
        n.right = new Node(22);
        n.right.right = new Node(25);
        n.right.right.right = new Node(19);
        n.left.left = new Node(4);
        n.left.right = new Node(12);
        n.left.right.left = new Node(10);
        n.left.right.right = new Node(14);
        System.out.println(maxSum(n,0));
    }
}
