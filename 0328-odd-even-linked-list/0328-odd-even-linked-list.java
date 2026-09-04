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
    public ListNode oddEvenList(ListNode head) {
        // Traverse the odd indices lists & even indices lists at a time
        // Move the odd & even pointers as well
        // At the moment even pointer moving forward. Maintain "EvenHead" pointer for connecting the odd ones with even ones..
        if(head == null){
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        // Maintain evenhead pointer. It will be useful for connecting..
        ListNode evenHead = even; 

        // This loop keep moving forward and connecting odd's & even's
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }
        // After completing the loop, even pointer is at null
        // Simply connect the evenhead with oddlist
        odd.next = evenHead;

        return head;
    }
}