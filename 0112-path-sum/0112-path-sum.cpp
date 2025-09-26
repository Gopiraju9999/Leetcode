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
    bool hasPathSum(TreeNode* root, int targetSum) {
        if(root == nullptr) return false;
        // leaf nodes...
        if(root->left == nullptr && root->right == nullptr){
            return(targetSum - root->val == 0);
        }
        // checks left or right subtree
        return (hasPathSum(root->left, targetSum - root->val) ||
        hasPathSum(root->right, targetSum - root->val));
    }
};