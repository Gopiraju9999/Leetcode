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
    bool isValidBST(TreeNode* root, long min_val = LONG_MIN, long max_val = LONG_MAX) {
        if(!root) return true;
        if(root->val <= min_val || root->val >= max_val){
            return false;
        }
        return isValidBST(root->left, min_val, root->val)&&
                isValidBST(root->right, root->val, max_val);
    }
};