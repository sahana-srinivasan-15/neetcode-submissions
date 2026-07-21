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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "#";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                sb.append("#,");
            }
            else{
                sb.append(curr.val).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }}
         return sb.toString();
        }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())return null;
        String[]values = data.split(",");
        if(data.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode>q = new ArrayDeque<>();
        q.add(root);
        int i=1;
        while(!q.isEmpty()&&i<values.length){
            TreeNode curr = q.poll();
            if(!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                curr.left = left;
                q.offer(left);
            }
            i++;
             if(!values[i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                curr.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}
