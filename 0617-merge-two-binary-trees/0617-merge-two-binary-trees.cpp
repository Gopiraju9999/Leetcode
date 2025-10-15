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
    TreeNode* mergeTrees(TreeNode* root1, TreeNode* root2) {
        if(root1 == nullptr) return root2; // If root1 is empty, return root2
        if(root2 == nullptr) return root1; // If root2 is empty, return root1

        root2->val += root1->val; // both are !nullptr. Then, add root1 value into root2

        root2->left = mergeTrees(root1->left, root2->left); // merge root1 left with root2
        root2->right = mergeTrees(root1->right, root2->right); // merge root1 right to root2

        return root2;
    }
};