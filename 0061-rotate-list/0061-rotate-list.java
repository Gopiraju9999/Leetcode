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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || k == 0) return head;

        ListNode tail = head;
        int length = 1;

        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        if(k % length == 0) return head;

        k = k % length;

        tail.next = head;
        ListNode newnode = Nthnode(head, length - k);
        head = newnode.next;
        newnode.next = null;

        return head;
    }
    public ListNode Nthnode(ListNode temp, int k){
        int cnt = 1;

        while(temp != null){        // k = 14, => we move only 4 moves..
            if(cnt == k) return temp; // we just pointing the pointer at kth node
            cnt++;
            temp = temp.next;
        }
        return temp;
    }
}