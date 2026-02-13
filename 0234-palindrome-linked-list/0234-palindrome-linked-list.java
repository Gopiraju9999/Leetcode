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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // Follow up for odd length list
        if(fast != null)
            slow = slow.next;

        ListNode second_half = reverse(slow);
        ListNode first_half = head;
        // Checking for the palindrome condition..
        while(second_half != null){
            if(first_half.val != second_half.val)
                return false;

            first_half = first_half.next;
            second_half = second_half.next;
        }
        return true;
    }

    // Function for reversing the second part of the list..
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp = head;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}