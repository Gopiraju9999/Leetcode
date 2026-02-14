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
    ListNode* reverse(ListNode* head){
        ListNode* prev = nullptr;
        ListNode* temp = head;
        while(temp != nullptr){
            ListNode* front = temp->next;
            temp->next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    
    bool isPalindrome(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return true;

        ListNode* fast = head;
        ListNode* slow = head;
        while(fast != nullptr && fast->next != nullptr){
            fast = fast->next->next;
            slow = slow->next;
        }

        // Handling for odd length lists..
        if(fast != nullptr){
            slow = slow->next;
        }

        ListNode* second_half = reverse(slow);
        ListNode* first_half = head;

        while(second_half != nullptr){
            if(first_half->val != second_half->val){
                return false;
            }
            first_half = first_half->next;
            second_half = second_half->next;
        }
        return true;
    }
};