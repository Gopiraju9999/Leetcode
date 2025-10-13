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
    TreeNode* invertTree(TreeNode* root) {
       if(root == nullptr) return nullptr;

       queue<TreeNode*>q;
       q.push(root);
        // Same process.. but little bit change..
        // Reversing and inverting both are not same!!
       while(!q.empty()){
            TreeNode* node = q.front();
            q.pop();
            // Swap the both nodes of the tree..
            swap(node->left, node->right);

            if(node->left) q.push(node->left);
            if(node->right) q.push(node->right);
        }
       return root;
    }
};