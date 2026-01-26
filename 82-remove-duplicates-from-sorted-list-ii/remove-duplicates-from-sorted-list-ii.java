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
    public ListNode deleteDuplicates(ListNode head) {
       if (head == null) return null;

    // First, move head if duplicates start from beginning
    while (head != null && head.next != null && head.val == head.next.val) {
        int dup = head.val;
        while (head != null && head.val == dup) {
            head = head.next;
        }
    }

    ListNode current = head;

    while (current != null && current.next != null && current.next.next != null) {
        if (current.next.val == current.next.next.val) {
            int dup = current.next.val;

            // skip all duplicate nodes
            while (current.next != null && current.next.val == dup) {
                current.next = current.next.next;
            }
        } else {
            current = current.next;
        }
    }

    return head;
    }
}