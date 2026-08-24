/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // Base case..
        if(root == null) return null;

        // Recursive moves{left, right} sides..
        TreeNode left_side = removeLeafNodes(root.left, target);
        TreeNode right_side = removeLeafNodes(root.right, target);

        root.left = left_side;
        root.right = right_side;

        // Core condition for leaf nodes..
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }
        return root;
    }
}