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
    int kthSmallest(TreeNode* root, int k) {
        vector<int>ans;
        Inorder(root, ans);
        return ans[k-1];
    }
    void Inorder(TreeNode* node, vector<int>&ans){
        if(!node) return;

        // Inorder Travesal..
        Inorder(node->left, ans);
        ans.push_back(node->val);
        Inorder(node->right, ans);
    }
};