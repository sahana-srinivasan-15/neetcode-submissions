class Solution {
    public int hammingWeight(int n) {
        int bit =0,count =0;
        while(n!=0){
            bit = n%2;
            if(bit==1)count++;
            n/=2;
        }
        return count;
    }
}
