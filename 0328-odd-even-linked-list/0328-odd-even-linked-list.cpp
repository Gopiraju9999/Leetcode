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
    ListNode* oddEvenList(ListNode* head) {
        if(head == NULL || head->next == NULL) return head;
      ListNode *odd = head;
      ListNode *even = head->next;
      ListNode *evenHead = even; //saving the starting node of even index

      while(even != NULL && even->next != NULL){
        odd->next = odd->next->next;
        odd = odd->next;

        even->next = even->next->next;
        even = even->next;
      }
      odd->next = evenHead; // attach even list after odd list
      return head;
    }
};