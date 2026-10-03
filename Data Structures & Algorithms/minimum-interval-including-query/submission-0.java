class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int [][]sorted = new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            sorted[i][0]=queries[i];
            sorted[i][1]=i;
        }
        Arrays.sort(sorted,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int [] result = new int[queries.length];
        int j = 0;
        for(int []query:sorted){
            int q = query[0];
            while(j<intervals.length&&intervals[j][0]<=q){
               int start = intervals[j][0];
               int end = intervals[j][1];
               int size = end-start+1;
               pq.offer(new int[]{size,end});
               j++;
            }
            while(!pq.isEmpty()&&pq.peek()[1]<q){
                pq.poll();
            }
            if(pq.isEmpty()){
                result[query[1]]=-1;
            }
            else{
                result[query[1]]=pq.peek()[0];
            }
        }
        return result;
    }
}
