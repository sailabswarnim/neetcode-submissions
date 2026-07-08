class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1){
            return 0;
        }
        int[] maxToRight = new int[n];
        maxToRight[n-1] = prices[n-1];
        int maxSoFar = prices[n-1];
        for(int i = n - 2; i >0; i--){
            maxSoFar = Math.max(maxSoFar, prices[i + 1]);
            maxToRight[i] = maxSoFar;
        }
        maxToRight[0] = Math.max(maxSoFar, prices[1]);

        Integer maxProf = 0;
        for(int i = 0; i < n - 1; i++){
            maxProf = Math.max(maxProf, maxToRight[i] - prices[i]);
        }

        return maxProf;
    }
}
