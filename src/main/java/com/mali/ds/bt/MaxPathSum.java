package com.mali.ds.bt;

import java.util.ArrayList;
import java.util.List;

public class MaxPathSum {
    static int maxPathSum(Node n, int ans) {

        if (n == null) {
            return 0;
        }
        int l = maxPathSum(n.left, ans);
        int r = maxPathSum(n.right, ans);
        List<Integer> list = new ArrayList();
        list.add(r+n.data);
        list.add(l+n.data);
        list.add(n.data);
        return list.stream().max(Integer::compareTo).get();

    }

    public static void main(String args[]) throws Exception {
        Node n = new Node(20);
        n.left = new Node(8);
        n.right = new Node(22);
        n.right.right = new Node(25);
        n.right.right.right = new Node(-19);
        n.left.left = new Node(4);
        n.left.right = new Node(12);
        n.left.right.left = new Node(10);
        n.left.right.right = new Node(14);
        System.out.println(maxPathSum(n, 0));
    }
}
