/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public void reorderList(ListNode head) {
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
            if (temp == stack.pop()) {
                cur = temp;
                break;
            }
            cur.next.next = temp;
            cur = temp;
        }
        cur.next = null;
    }
}
