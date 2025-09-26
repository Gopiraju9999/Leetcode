/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        // Base cases...
       if(p == nullptr && q == nullptr) return true; // Both fails 
        if(p == nullptr || q == nullptr) return false; // one exist, one fail
        if(p->val != q->val) return false; // Both node isn't equal
        // Reccursive Callssss..
        return isSameTree(p->left,q->left) && isSameTree(p->right, q->right);
    }
};