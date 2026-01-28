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
    public ListNode sortList(ListNode head) {
       if (head == null || head.next == null) {
            return head;
        }

        // 1️⃣ Split the list
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        // 2️⃣ Sort both halves
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        return merge(leftSorted, rightSorted);
    }
      private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head, tail;
        if (l1.val <= l2.val) {
            head = tail = l1;
            l1 = l1.next;
        } else {
            head = tail = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return head;
    }
}