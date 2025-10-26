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
    bool findTarget(TreeNode* root, int k) {
        vector<int>ans;
        DFS(root, ans);

        int left = 0, right = ans.size()-1;
        while(left < right){
            int sum = ans[left] + ans[right];
            if(sum == k) return true;
            else if(sum > k) right--;
            else left++;
        }
        return false;
    }
    void DFS(TreeNode* node, vector<int>& ans){
        if(!node) return;

        DFS(node->left, ans);
        ans.push_back(node->val);
        DFS(node->right, ans);
    }
};