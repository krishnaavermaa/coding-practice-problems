class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int sm=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<=sm) sm=prices[i];
            else if(prices[i]-sm>profit) profit=prices[i]-sm;
        }
        //System.out.print(sm+" "+profit);
        
        return profit;
    }
}