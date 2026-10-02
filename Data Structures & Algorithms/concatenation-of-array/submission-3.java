class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] num2 = new int[2*(nums.length)];
        int j=0;
        for(int i=0;i<2;i++){
            for(int n:nums){
               num2[j++]=n;
            }
        }
        return num2;
    }
}