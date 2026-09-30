class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        return Math.max(robber(nums,0,n-2),robber(nums,1,n-1));
    }
    public int robber(int [] nums,int l,int r){
        if(l==r)return nums[l];
        int[]dp = new int[r-l+1];
        dp[0]=nums[l];
        dp[1]=Math.max(nums[l],nums[l+1]);
        for(int i = 2;i<dp.length;i++){
          dp[i]= Math.max(dp[i-1],dp[i-2]+nums[l+i]);
        }
        return dp[dp.length-1];
    }
}
