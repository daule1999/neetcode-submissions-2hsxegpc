class Solution {
    public int maxProfit(int[] prices) {
        int max=0; int n= prices.length; int start=0;int curreProfit=0;
        for(int i=0;i<n;i++){
            
            if(prices[start]<prices[i]){
                curreProfit=prices[i]-prices[start];
                max=Math.max(curreProfit, max);
            }else{
                start = i;
            }
        }
        return max;
    }
}
