/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void deleteNode(ListNode* node) {
       node->val = node->next->val; // Copy the value of next node to current node
       node->next = node->next->next; // Adjust the next pointer to skip the next node
    } // 1st step => 4->5->1->9 === 4->1->1->9
};    // 2nd atep => 4->1->1->9 === 4->1->9