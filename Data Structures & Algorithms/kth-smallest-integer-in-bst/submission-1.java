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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer>ll = new ArrayList<>();
        inorder(root,ll);
        return ll.get(k-1);
    }
    public void inorder(TreeNode node,List<Integer>ll){
        if(node==null)return;
        inorder(node.left,ll);
        ll.add(node.val);
        inorder(node.right,ll);
    }
}
