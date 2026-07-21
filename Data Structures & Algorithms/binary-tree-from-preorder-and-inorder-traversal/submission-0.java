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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length!=preorder.length)return null;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
          hm.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,preorder,0,preorder.length-1,hm);
    }
    public TreeNode build(int[]inorder,int is,int ie,int[]preorder,int ps,int pe,Map<Integer,Integer>hm){
        if(ps>pe||is>ie)return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int inroot = hm.get(preorder[ps]);
        int numsleft = inroot-is;
        root.left = build(inorder,is,inroot-1,preorder,ps+1,ps+numsleft,hm);
        root.right = build(inorder,inroot+1,ie,preorder,ps+numsleft+1,pe,hm);
       return root;
    }
}
