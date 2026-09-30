class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int prefix = 1,suffix =1;
        for(int i=0;i<nums.length;i++){
            prefix = (prefix==0?1:prefix)*nums[i];
            suffix = (suffix==0?1:suffix)*nums[n-1-i];
            res = Math.max(res,Math.max(prefix,suffix));
        }
        return res;
    }
}
