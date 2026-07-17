class Solution {
    // top down
    public int numDecodings(String s) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        dfs(s, 0, dp);
        return dfs(s, 0, dp);
    }

    public int dfs(String s, int start, HashMap<Integer, Integer> dp){
        if(dp.containsKey(start)){
            return dp.get(start);
        }
        if(start == s.length()){
            return 1;
        }

        if(s.charAt(start) == '0'){
            return 0;
        }

        // 1 char paths
        int result = dfs(s, start + 1, dp);

        // 2 char paths
        if(start < s.length() - 1){
            if(s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(start + 1) < '7')){
                result += dfs(s, start + 2, dp);
            }
        }

        dp.put(start, result);
        return result;
    }
}


///[2,1,3,5,6]

// [1,3,5,6].    [3,5,6]

// [3,5,6] [5,6].  [5,6]