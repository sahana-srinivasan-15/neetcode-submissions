class Solution {
    public int countComponents(int n, int[][] edges) {
      int count = 0;
      List<List<Integer>> adj = new ArrayList<>();
      for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
      }
      for(int[]e:edges){
        adj.get(e[0]).add(e[1]);
        adj.get(e[1]).add(e[0]);
      }
      boolean[]visit = new boolean[n];
     
      for(int i=0;i<n;i++){
        if(!visit[i]){
            count++;
            dfs(i,visit,adj);
        }
      }
      return count;
    }

    public void dfs(int i,boolean[] visit,List<List<Integer>>adj){
        visit[i]=true;
        for(int nei:adj.get(i)){
            if(!visit[nei]){
                dfs(nei,visit,adj);
            }
        }
    }
}
