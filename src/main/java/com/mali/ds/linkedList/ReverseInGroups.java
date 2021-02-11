package com.mali.ds.linkedList;

public class ReverseInGroups {

    public static Node reverse(Node node, int k)
    {
//Your code here
        Node ans = node;
        Node prev = null;
        Node next;
        Node temp = node;
        int d = 0;
        while(d < k-1){
            ans = ans.next;
            d++;
        }
        d = 0;
        while(node.next != null){
            if(d == k-1){
                temp.next = node;
                temp = node;
                d = 0;
            } else{
                next = node.next;
                node.next = prev;
                prev = node;
                node = next;
                d++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node ans = head;
        int[] A = {2, 2, 4, 5, 6, 7, 8};
        for (int i = 0; i < A.length; i++) {
            Node n = new Node(A[i]);
            head.next = n;
            head = head.next;
        }

        ans = reverse(ans, 3);
        System.out.print(ans);
    }
}
