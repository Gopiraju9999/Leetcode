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
    // Main function is used to returning the result only....
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>>result;
        vector<int>path;
        DFS(root, targetSum, path, result);
        return result;
    }
    // Main function is used to do the complete logical operations...
    void DFS(TreeNode* node, int targetSum, vector<int>&path, vector<vector<int>>&result){
        if(!node) return;

        // Continuously, add the value into path vector and check the target and sum
        path.push_back(node->val);
        targetSum -= node->val;

        // Leafnodes and target sum having "0". Then, this path can exists...
        if(!node->left && !node->right && targetSum == 0){
            result.push_back(path);
        }
        
        // Recursively calling the both side of tree
        DFS(node->left, targetSum, path, result);
        DFS(node->right, targetSum, path, result);

        path.pop_back(); // Backtracking the path vector. coz, checking for another path
    }
};