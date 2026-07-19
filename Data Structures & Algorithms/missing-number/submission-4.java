class Solution {
    public int missingNumber(int[] nums) {
      int n = nums.length;
      int expected = (n*(n+1))/2;
      int ans = 0;
      for(int x:nums){
        ans+=x;
      }
      return expected - ans;
    }
}
