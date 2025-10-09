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
    bool isSymmetric(TreeNode* root) {
        if(root == nullptr) return true;
        return Symmetric(root->left, root->right);
    }
    bool Symmetric(TreeNode*t1, TreeNode*t2){
        if(t1 == nullptr && t2 == nullptr) return true; // Both are mirror
        if(t1 == nullptr || t2 == nullptr) return false; // Both aren't
        return (t1->val == t2->val) && Symmetric(t1->left, t2->right) && 
        Symmetric(t1->right, t2->left);
    }
};