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
    ListNode* deleteDuplicates(ListNode* head) {
        
       ListNode *dummy = new ListNode(-1);
       dummy->next = head;
       ListNode *prev = dummy;
       ListNode *curr = head;
       while(curr != NULL && curr->next != NULL){
        if(curr->next && curr->val == curr->next->val){
            while(curr->next && curr->val == curr->next->val){
                curr = curr->next; // Till moves at the end of duplicates
            }
            prev->next = curr->next; // Ignore the duplicate nodes
        }else{
            prev = prev->next; // Found single nodes, moves to next node
        }
        curr = curr->next;
       }
       return dummy->next;
    }
};