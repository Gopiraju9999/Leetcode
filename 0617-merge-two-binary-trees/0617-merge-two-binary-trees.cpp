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

        TreeNode* merge = new TreeNode(root1->val + root2->val); // add 2 roots into newnode
        merge->left = mergeTrees(root1->left, root2->left); // both leftnodes added to node
        merge->right = mergeTrees(root1->right, root2->right); // both rightnodes as well

        return merge;
    }
};