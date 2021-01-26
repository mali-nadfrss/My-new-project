package com.mali.ds.linkedList;

/*
 * easy 2
 * https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists
 * */
public class AddTwoNumbers {

    static Node addTwoLists(Node first, Node second) {
        // code here
        // return head of sum list
        int d1 = 0;
        int d2 = 0;
        Node head1 = first;
        Node head2 = second;
        // find the count of nodes in each list
        while (head1 != null) {
            d1++;
            head1 = head1.next;
        }

        while (head2 != null) {
            d2++;
            head2 = head2.next;
        }
        Node ans = new Node(0);
        // based on the length of lists, decide which is longer and call that first
        if (d1 > d2) {
            ans = recursiveSum(first, d1 - d2, second);
        } else {
            ans = recursiveSum(second, d2 - d1, first);
        }
        //after we get result just check if carry is still greater than 0 if so add that as head
        if (carry > 0) {
            Node n = new Node(carry);
            n.next = ans;
            return n;
        }
        return ans;

    }


    static Node recursiveSum(Node first, int d, Node second) {
        if (d == 0) {
            return recursiveDoubleSum(first, second);
        }
        //here we calculate the longer list node along with carry
        Node n = new Node(0);
        n.next = recursiveSum(first.next, --d, second);
        int temp = first.data + carry;
        n.data = temp % 10;
        carry = temp / 10;
        return n;
    }

    static int carry = 0;

    // here we calculate
    static Node recursiveDoubleSum(Node first, Node second) {
        if (first == null) {
            return null;
        }
        Node ans = new Node(0);
        ans.next = recursiveDoubleSum(first.next, second.next);
        int temp = first.data + second.data + carry;
        ans.data = temp % 10;
        carry = temp / 10;
        return ans;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node ans1 = head;
        int[] A = {9, 6, 2, 6, 8, 2, 1, 8, 0, 9, 6};
        for (int i = 0; i < A.length; i++) {
            Node n = new Node(A[i]);
            head.next = n;
            head = head.next;
        }
        head = new Node(6);
        Node ans2 = head;
        A = new int[]{1, 9, 3, 7, 1, 5, 7, 9};
        for (int i = 0; i < A.length; i++) {
            Node n = new Node(A[i]);
            head.next = n;
            head = head.next;
        }

        Node ans = addTwoLists(ans2, ans1);
        System.out.print(ans);
    }
}
