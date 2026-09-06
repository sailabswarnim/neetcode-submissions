class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        for(int i = 0; i < n; i++){
            if(i == src){
                prices[i] = 0;
            } else {
                prices[i] = Integer.MAX_VALUE;
            }
        }

        
        int stops = 0;
        while(stops <= k){

            int[] temp = Arrays.copyOf(prices, n);

            for(int[] edge : flights){
                int source = edge[0];
                int destination = edge[1];
                int price = edge[2];

                if(prices[source] == Integer.MAX_VALUE){
                    continue;
                }

                temp[destination] = Math.min(temp[destination], prices[source] + price);
            }

            prices = temp;

            stops++;
        }

        return (prices[dst] == Integer.MAX_VALUE) ? -1 : prices[dst];
    }
}
