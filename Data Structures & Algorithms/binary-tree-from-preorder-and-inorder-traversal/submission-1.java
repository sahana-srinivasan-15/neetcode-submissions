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
    int preidx = 0;
    int inidx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,inorder,Integer.MAX_VALUE);
    }
    public TreeNode dfs(int[]preorder,int[]inorder,int limit){
        if(preidx>=preorder.length){
            return null;
        }
        if(inorder[inidx]==limit){
            inidx++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[preidx++]);
        root.left = dfs(preorder,inorder,root.val);
        root.right = dfs(preorder,inorder,limit);
        return root;
    }
}
