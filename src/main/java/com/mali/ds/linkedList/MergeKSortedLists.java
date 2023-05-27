package com.mali.ds.linkedList;

import java.util.PriorityQueue;

/* https://leetcode.com/problems/merge-k-sorted-lists/submissions/
 * hard */
public class MergeKSortedLists {

  // Definition for singly-linked list.
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

  public static ListNode mergeKLists(ListNode[] lists) {
    ListNode ans = new ListNode(-1);
    ListNode cur = ans;
    PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
    boolean flag = true;
    while (flag) {
      flag = false;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          pq.add(lists[i]);
          lists[i] = lists[i].next;
          flag = true;
        }
      }
    }
    while (!pq.isEmpty()) {
      cur.next = new ListNode(pq.poll().val);
      cur = cur.next;
    }
    return ans.next;
  }

  public static void main(String[] args) {
    int[][] lists = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(5);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    ListNode l3 = new ListNode(2);
    l3.next = new ListNode(6);
    ListNode[] arr = new ListNode[] {l1, l2, l3};
    mergeKLists(arr);
  }
}
