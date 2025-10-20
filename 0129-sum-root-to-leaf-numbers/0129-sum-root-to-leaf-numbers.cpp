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
    int total_sum = 0; // Initialize as Global Variable
    // Main function for initializing and returning the result
    int sumNumbers(TreeNode* root) {
       if(!root) return 0;
       DFS(root, 0);
       return total_sum; 
    }
    // Supportive function is for doing operations..
    void DFS(TreeNode* node, int count){
        if(!node) return;

        // Instead of using concatenation
        count = count*10 + node->val; // 

        // if leafnodes arrived add that amount of sum into totalsum and backtrack it!!!
        if(!node->left && !node->right){
            total_sum += count;
            return;
        }
        // Recursively calling the both sides of tree
        DFS(node->left, count);
        DFS(node->right, count);
    }
};