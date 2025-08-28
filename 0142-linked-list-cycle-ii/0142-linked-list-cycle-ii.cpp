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
    ListNode *detectCycle(ListNode *head) {
      ListNode *fast = head;
      ListNode *slow = head;
      while(fast != nullptr && fast->next != nullptr){
        fast = fast->next->next;
        slow = slow->next;
        if(fast == slow){ // After fast & slow met
            slow = head; // slow pointing to head
            while(slow != fast){ // finds the meeted place 
                fast = fast->next;
                slow = slow->next;
            }
            return slow;
        }
      }
      return nullptr;;
    }
};