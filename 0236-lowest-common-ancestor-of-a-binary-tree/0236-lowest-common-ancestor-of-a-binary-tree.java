/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if(root == null) return null;

        // Answer cases..
        // Assume like my current node is "p" or "q". If it exist simply return that root
        if(root == p || root == q) return root;

        // Recursive calls
        // Just assume like, these calls are used to move either left or right
        TreeNode left_side = lowestCommonAncestor(root.left, p, q);
        TreeNode right_side = lowestCommonAncestor(root.right, p, q);

        // returning calls & explanation
        // It means, if the leftside & rightside of tree is null. Then, return root
        if(left_side != null && right_side != null){
            return root;
        }
        // "I didn't find anything useful on my right. My left subtree already has the answer, so I'll pass that answer upward."
        else if(left_side != null && right_side == null){
            return left_side;
        }
        // Same, I found answer at rightside & there is nothing at leftside. so, I'll pass that answer upward.
        else if(left_side == null && right_side != null){
            return right_side;
        }
        // Nothing found at left & right sides
        else{
            return null;
        }
    }
}