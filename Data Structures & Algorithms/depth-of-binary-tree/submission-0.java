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
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode>q = new ArrayDeque<>();
        int level =0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode f = q.poll();
                if(f.left!=null){
                    q.add(f.left);
                }
                 if(f.right!=null){
                    q.add(f.right);
                }
            }
            level++;
        }
        return level;
    }
}
