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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();

        Inorder(root, result);
        return result;
    }

    private void Inorder(TreeNode node, List<Integer>result){
        if(node == null) return;

        // Inorder => Left - Root - Right..
        Inorder(node.left, result);
        result.add(node.val);
        Inorder(node.right, result);
    }
}