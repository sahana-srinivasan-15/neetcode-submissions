class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer>free = new PriorityQueue<>();
        PriorityQueue<int[]>used = new PriorityQueue<>((a,b)->a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        int [] count = new int[n];
        for(int i=0;i<n;i++){
            free.offer(i);
        }
        for(int [] meeting:meetings){
            int start = meeting[0];
            int end = meeting[1];
            while(!used.isEmpty()&&used.peek()[0]<=start){
                free.offer(used.poll()[1]);
            }
            if(!free.isEmpty()){
                int room = free.poll();
                count[room]++;
                used.offer(new int[]{end,room});
            }
            else{
                int[]earliest = used.poll();
                count[earliest[1]]++;
                used.offer(new int[]{earliest[0]+(end-start),earliest[1]});
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            if(count[i]>count[res]){
                res=i;
            }
        }
        return res;
    }
}