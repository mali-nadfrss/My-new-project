package com.mali.ds.linkedList;

/* https://leetcode.com/contest/weekly-contest-358/problems/double-a-number-represented-as-a-linked-list/ */
public class DoubleaNumberRepresentedasaLinkedList {

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

  public static ListNode doubleIt(ListNode head) {

    ListNode prev = new ListNode(0);
    ListNode next;

    // -1prev <-1 prev  <- 8 prev 9 head
    while (head != null) {
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }

    int carry = 0;
    head = prev;
    prev = null;
    while (head != null) {
      int val = head.val;
      head.val = (2 * head.val + carry) % 10;
      if (val > 4) {
        carry = 1;
      } else {
        carry = 0;
      }
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }


    if (prev.val != 0) {
      return prev;
    } else {
      return prev.next;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(9);
    ListNode head1 = new ListNode(9);
    ListNode head2 = new ListNode(9);
    head.next = head1;
    head1.next = head2;

    doubleIt(head);
  }
}
