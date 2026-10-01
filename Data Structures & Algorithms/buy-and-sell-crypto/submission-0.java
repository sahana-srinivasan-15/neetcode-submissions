class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int pro =1;
        for(int price:prices){
            if(price<min){
                min = price;
            }
             pro = price-min;
            if(pro>max){
                max = pro;
            }
        }
        return max;
    }
}
