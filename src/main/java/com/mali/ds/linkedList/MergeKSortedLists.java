package com.mali.ds.linkedList;

import java.util.PriorityQueue;

/* https://leetcode.com/problems/merge-k-sorted-lists/submissions/
 * hard */
public class MergeKSortedLists {

  // Definition for singly-linked list.
  public class ListNode {
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

  public ListNode mergeKLists(ListNode[] lists) {

    PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
    ListNode ans = null;
    ListNode current = null;

    for (ListNode node : lists) {
      if (node != null) {
        pq.add(node);
      }
    }
    while (!pq.isEmpty()) {
      ListNode temp = pq.remove();
      if (ans == null) {
        ans = temp;
      } else {
        current.next = temp;
      }
      if (temp.next != null) {
        pq.add(temp.next);
      }
      current = temp;
    }
    return ans;
  }
}
