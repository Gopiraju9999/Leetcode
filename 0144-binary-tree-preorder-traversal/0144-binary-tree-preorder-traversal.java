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
    // Head Func job is to reference another function and return the answer...
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();

        Preorder(root, result);
        return result;
    }

    // Supportive Func job is to complete the task where the head func couldn't done & return..
    private void Preorder(TreeNode node, List<Integer>result){
        if(node == null) return;

        // Preoder => Root - Left - Right...
        result.add(node.val);
        Preorder(node.left, result);
        Preorder(node.right, result);
    }
}