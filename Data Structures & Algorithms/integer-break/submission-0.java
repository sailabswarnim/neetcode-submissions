class Solution {
    HashMap<Integer, Integer> memo ;
    public int integerBreak(int n) {
        memo = new HashMap<>();
        return integerBreakRec(n);
    }

    public int integerBreakRec(int n){
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        if(n == 1){
            memo.put(n, 1);
            return 1;
        }

        int result = 0;
        for(int i = 1; i < n; i++){
            result = Math.max(result, Math.max(i * (n-i), i * integerBreakRec(n-i)));
        }

        memo.put(n, result);
        return result;
    }
}