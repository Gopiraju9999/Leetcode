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
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>result = new ArrayList<>();

        if(root == null) return result;
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer>level = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                level.add(node.val);

                if(node.right != null) q.offer(node.right);
                if(node.left != null) q.offer(node.left);
            }
            result.add(level.get(0));    // Way to get & add last element "list.size()-1"
        }
        return result;
    }
}