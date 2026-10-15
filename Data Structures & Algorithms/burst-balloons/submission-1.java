class Solution {
    // Top Down Memoised
    HashMap<String, Integer> memo = new HashMap<>();
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] numbers = new int[n + 2];
        numbers[0] = 1;
        numbers[numbers.length - 1] = 1;
        for(int i = 1; i <= n; i++){
            numbers[i] = nums[i-1];
        }

        return maxCoinsRec(numbers, 1, numbers.length - 2);
    }

    public int maxCoinsRec(int[] numbers, int start, int end){
        if(start > end){
            return 0;
        }

        String key = start + "-" + end;
        if (memo.containsKey(key)){
            return memo.get(key);
        }

        int res = Integer.MIN_VALUE;
        int cost = 0;
        for(int i = start; i <= end; i++){
            cost = numbers[start - 1] * numbers[i] * numbers[end + 1] + (maxCoinsRec(numbers, start, i - 1) + maxCoinsRec(numbers, i+1, end));

            res = Math.max(res, cost);
        }

        memo.put(key, res);
        return res;
    }
}
