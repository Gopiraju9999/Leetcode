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
    int goodNodes(TreeNode* root) {
        return DFS(root, root->val);
    }
   
    int DFS(TreeNode* root, int maxi){
        if(root == nullptr) return 0;
        int count = 0;

        if(root->val >= maxi) count = 1;

        maxi = max(maxi, root->val);
        count += DFS(root->left, maxi);
        count += DFS(root->right, maxi);

        return count;
    }
};