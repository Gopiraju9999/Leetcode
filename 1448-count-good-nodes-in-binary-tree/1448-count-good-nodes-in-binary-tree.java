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
    public int goodNodes(TreeNode root) {
        return DFS(root, root.val);
    }
    private int DFS(TreeNode root, int maxi){
        if(root == null) return 0;
        int count = 0;

        if(root.val >= maxi){
            count = 1;
        }

        // comparing every current value with maximum
        maxi = Math.max(maxi, root.val);
        // Recursive calls..
        count += DFS(root.left, maxi);
        count += DFS(root.right, maxi);

        return count;
    }
}