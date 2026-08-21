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
    public ListNode deleteMiddle(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;  

        // fast pointer used for loop condition..
        // slow pointer used for picking/pointing middle (delete) node
        // prev pointer used to stay back to slow pointer. when slow picks then it deletes..

        while(fast != null && fast.next != null){
            prev = slow;        // "prev" "slow pointer" ni refer chesthadi delete cheyyaniki..
            slow = slow.next;
            fast = fast.next.next;
        }

        // After the loop ends, slow itself will be the delete node..
        prev.next = slow.next;

        return head;
    }
}