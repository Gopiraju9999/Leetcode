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
    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        if(root == NULL) return root;

        TreeNode* left_side = removeLeafNodes(root->left, target);
        TreeNode* right_side = removeLeafNodes(root->right, target);
        
        root->left = left_side;
        root->right = right_side;

        if(root->left == NULL && root->right == NULL && root->val == target){
            return NULL;
        }
        return root;
    }
};