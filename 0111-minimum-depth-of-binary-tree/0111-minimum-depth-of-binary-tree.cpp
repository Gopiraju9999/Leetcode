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
    int minDepth(TreeNode* root) {
        if(root == nullptr) return 0;
        // If one side is directly null, then return another side depth+1(root)
        if(root->left == nullptr) return minDepth(root->right)+1;
        if(root->right == nullptr) return minDepth(root->left)+1;

        int left_depth = minDepth(root->left);
        int right_depth = minDepth(root->right);

        return min(left_depth, right_depth)+1; // includes root also...
    }
};