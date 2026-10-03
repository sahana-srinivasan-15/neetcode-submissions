/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid,grid.length,0,0);
    }
    public Node dfs(int[][]grid,int size,int row,int col){
        boolean same = true;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(grid[row][col]!=grid[row+i][col+j]){
                    same = false;
                    break;
                }
            }
        }
        if(same){
            return new Node(grid[row][col]==1,true);
        }
        int mid = size/2;
        Node topLeft = dfs(grid,mid,row,col);
        Node topRight = dfs(grid,mid,row,col+mid);
        Node bottomLeft = dfs(grid,mid,row+mid,col);
        Node bottomRight = dfs(grid,mid,row+mid,col+mid);
        return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
    }
}