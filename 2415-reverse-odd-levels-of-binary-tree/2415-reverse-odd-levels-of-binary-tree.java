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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;

        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode>result = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                result.add(node);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            
            // Now, check the level is odd or not..
            if(level % 2 == 1){
                Reverse(result);
            }
            level++;
        }
        return root;
    }
    public void Reverse(List<TreeNode>result){
        int len = result.size();
        int left = 0, right = len-1;

        while(left < right){
            // Here TreeNode means, we're going to adding nodes
            // If the list has TreeNode, then we need to be present like "result.get().val"
            // If the list has "Integer" type then, simpily add like "result.get()"
            int temp = result.get(left).val;
            result.get(left).val = result.get(right).val;
            result.get(right).val = temp;
            left++;
            right--;
        }
    }
}