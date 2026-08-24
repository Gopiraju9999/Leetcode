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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);
        int answer = root.val;

        while(!q.isEmpty()){
            List<TreeNode>ans = new ArrayList<>();
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                // For every level it stores only the first element.
                if(i == 0){
                    answer = node.val;
                }

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return answer;
    }
}