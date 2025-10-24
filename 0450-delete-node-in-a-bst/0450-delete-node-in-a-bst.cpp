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
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(!root) return NULL;
        // These are moving Conditions..
        if(root->val > key) root->left = deleteNode(root->left, key);
        else if(root->val < key) root->right = deleteNode(root->right, key);

        // Check it's leaf nodes are not??
        else{
            if(root->left == nullptr){ // checking for left leaf node is null
                TreeNode* temp = root->right;
                delete root;
                return temp;
            } else if(root->right == nullptr){ // checking for right leaf node is null
                TreeNode* temp = root->left;
                delete root;
                return temp;
            }
            // case : 3 Two childrens
            TreeNode* successor = root->right;
            while(successor->left) // Go as far as root->left
                successor = successor->left; // store successor-> left into successor
                root->val = successor->val; // that smaller value store into root->val
                root->right = deleteNode(root->right, successor->val); // delete it..
        }
        return root;
    }
};