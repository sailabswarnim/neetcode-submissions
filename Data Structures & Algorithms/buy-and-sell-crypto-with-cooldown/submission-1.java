class Solution {
    // Top Down
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> memo = new HashMap<>();
        return maxProfitRec(prices, 0, 1, memo);
    }

    public int maxProfitRec(int[] prices, int start, int buying, HashMap<String, Integer> memo) {
        if(start >= prices.length){
            return 0;
        }

        String key = String.valueOf(start) + "-" + String.valueOf(buying);
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int cooldown = maxProfitRec(prices, start + 1, buying, memo);
        
        if(buying == 1){
            // buy
            int buy = maxProfitRec(prices, start + 1, 0, memo) - prices[start];
            memo.put(key, Math.max(buy, cooldown));
        } else {
            // sell
            int sell = maxProfitRec(prices, start + 2, 1, memo) + prices[start];
            memo.put(key, Math.max(sell, cooldown));
        }

        return memo.get(key); 
    }
}
