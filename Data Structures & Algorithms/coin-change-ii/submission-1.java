class Solution {
    // top down dp
    public int change(int amount, int[] coins) {
        HashMap<List<Integer>, Integer> memo = new HashMap<>();
        return changeRec(amount, coins, 0, memo);
    }

    public int changeRec(int amount, int[] coins, int start, HashMap<List<Integer>, Integer> memo){
        List<Integer> key = List.of(amount, start);
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(amount < 0){
            memo.put(key, 0);
            return 0;
        }

        if(amount == 0){
            memo.put(key, 1);
            return 1;
        }

        if(start == coins.length){
            memo.put(key, 0);
            return 0;
        }

        // include
        int ways = 0;
        ways = changeRec(amount - coins[start], coins, start, memo);

        //exclude
        ways += changeRec(amount, coins, start + 1, memo);

        memo.put(key, ways);
        return ways;
    }
}