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
    // Main Function is only for storing the result and return it back;
    vector<string> binaryTreePaths(TreeNode* root) {
       vector<string>result;
       DFS(root, "", result);
       return result; 
    }

    // Supportive Function is doing complete logic and required operations of problem
    void DFS(TreeNode* node, string path, vector<string>& result){
        if(!node) return;

        if(!path.empty()) path += "->";
        path += to_string(node->val); // if path is empty, directly add the current value

        // If both nodes having NULL, it means it's a leaf node
        if(!node->left && !node->right){
            result.push_back(path);  // push that viewed path into result vector.
            return;  // After that, then return it back
        }
        DFS(node->left, path, result); // Recursively calling leftside
        DFS(node->right, path, result); // Recursively calling rightside
    }
};