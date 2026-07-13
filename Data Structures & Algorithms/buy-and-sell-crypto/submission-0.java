class Solution {
    public int maxProfit(int[] prices) {
        int max=0; int n= prices.length;
        int[] postSum = new int[n]; int prevmax=prices[n-1];
        for(int i=n-1;i>=0;i--){
            postSum[i]=Math.max(prevmax, prices[i]);
            prevmax=Math.max(prevmax, prices[i]);
        }
        for(int i=0;i<n;i++){
            int currMax=postSum[i]-prices[i];
            max= Math.max(currMax, max);
        }
        return max;
    }
}
