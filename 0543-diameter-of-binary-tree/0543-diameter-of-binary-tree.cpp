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
    int diameter = 0; // Should be initialize as Globally

    int DFS(TreeNode* root) {
        if(!root) return 0;

        int left_side = DFS(root->left); // checks leftside of tree
        int right_side = DFS(root->right); // checks rightside of tree

        diameter = max(diameter, left_side + right_side); // update the value

        return 1 + max(left_side, right_side); // checks height of each node in tree
    }

    int diameterOfBinaryTree(TreeNode* root){
        DFS(root);
        return diameter;
    }
};