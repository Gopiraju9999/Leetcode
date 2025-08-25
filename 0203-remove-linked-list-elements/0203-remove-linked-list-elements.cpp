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
    ListNode* removeElements(ListNode* head, int val) {
        while(head != NULL && head->val == val){ // Nodes at the beginning with val == val
            head = head->next; // Move Forward
        }
       ListNode* ptr = head;
       while(ptr != NULL && ptr->next != NULL){ // Till last element 
        if(ptr->next->val == val){
            ptr->next = ptr->next->next; // Skip the node as current node
        } else{
            ptr = ptr->next; // Move Forward
        }
       }
       return head;
    }
};