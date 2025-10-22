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
    TreeNode* searchBST(TreeNode* root, int val) {
        if(!root) return nullptr; // It means nothing..
        // Found the value..
        if(root->val == val) return root;
        // The value should be in leftside of tree. Because, root smaller value at leftside
        if(root->val > val ) 
        return searchBST(root->left, val);
        // root bigger value should be at rightside..
        else 
        return searchBST(root->right, val);
    }
};