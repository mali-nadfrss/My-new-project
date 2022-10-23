package com.mali.ds.linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* https://leetcode.com/problems/reorder-list/ */
public class ReOrderList {


  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
      this.val = val;
    }
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static void reorderList(ListNode head) {

    if (head.next == null || head.next.next == null) return;
    Stack<ListNode> stack = new Stack<>();
    ListNode temp = head;
    while (temp != null) {
      stack.add(temp);
      temp = temp.next;
    }

    ListNode cur = head;
    while (!stack.isEmpty() && temp != stack.peek()) {
      temp = cur.next;
      cur.next = stack.peek();
      if(temp == stack.pop()){
        cur = temp;
        break;
      }
      cur.next.next = temp;
      cur = temp;
    }
    cur.next = null;
  }

  public static void main(String[] args) {


    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    reorderList(head);
  }
}
