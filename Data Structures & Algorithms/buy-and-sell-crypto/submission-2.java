class Solution {
    // one pass
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int maxProf = Integer.MIN_VALUE;
        int currProf = 0;

        for(int i = 1; i < prices.length; i++){
            currProf = prices[i] - minSoFar;
            maxProf = Math.max(maxProf, currProf);
            minSoFar = Math.min(minSoFar, prices[i]);
        }

        return (maxProf < 0) ? 0: maxProf;
    }
}
