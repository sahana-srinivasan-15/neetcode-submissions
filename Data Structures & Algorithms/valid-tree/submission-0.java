class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1)return false;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean [] visit = new boolean[n];
        if(dfs(0,-1,adj,visit)){
            return false;
        }
        for(boolean t:visit){
            if(!t){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int parent,List<List<Integer>>adj,boolean []visit){
        visit[node]=true;
        for(int nei:adj.get(node)){
            if(!visit[nei]){
                if(dfs(nei,node,adj,visit)){
                    return true;
                }
                 
            }
            else if(nei!= parent){
                return true;
            }

        }
        return false;
    }
}
