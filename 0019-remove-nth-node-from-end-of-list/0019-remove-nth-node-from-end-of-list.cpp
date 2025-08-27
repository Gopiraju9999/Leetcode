/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode *fast = head, *slow = head;
        for(int i = 0; i < n; i++){ // Fast pointer moves "n" steps 1st
            fast = fast->next;
        }
        if(fast == NULL) return head->next;
        while(fast->next != nullptr){ // moves both pointers slightly forward 
            fast = fast->next;        
            slow = slow->next;
        }
        slow->next = slow->next->next; // slow pointer next node is target node, ignore that
        return head;
    }
};