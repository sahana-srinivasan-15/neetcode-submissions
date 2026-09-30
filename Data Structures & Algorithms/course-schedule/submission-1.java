class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int [] indegree = new int[numCourses];
        for(int[]i:prerequisites){
            int course = i[0];
            int pre = i[1];
            adj.get(pre).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int n:adj.get(curr)){
                indegree[n]--;
                if(indegree[n]==0){
                    q.offer(n);
                }
            }
        }
        return count==numCourses;
    }
}
