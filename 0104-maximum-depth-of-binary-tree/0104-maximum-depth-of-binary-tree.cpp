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
    int maxDepth(TreeNode* root) {
        if(root == nullptr) return 0;
        queue<TreeNode*>q;
        q.push(root);
        int depth = 0;
 // Use BFS, check level by level, if level is completed this loop is completed. 
        while(!q.empty()){ // 
            int size = q.size();
            while(size--){
                TreeNode* node = q.front();
                q.pop();
                if(node->left != nullptr) q.push(node->left);// either this
                if(node->right != nullptr) q.push(node->right); // or this
            }
            depth++; // Then, increment the depth 
        }
        return depth;
    }
};