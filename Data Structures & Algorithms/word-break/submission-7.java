class Solution {
    // top down
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        Boolean[] dp = new Boolean[s.length() + 1];
        for(String str : wordDict){
            dict.add(str);
        }

        return dfs(s, 0, dict, dp);
    }

    public boolean dfs(String s, int start, HashSet<String> dict, Boolean[] dp) {
        if(start == s.length()){
            return true;
        }

        if(dp[start] != null){
            return dp[start];
        }

        for(int end = start + 1; end <= s.length(); end++){
            String sub = s.substring(start, end);
            if(dict.contains(sub) && (dfs(s, end, dict, dp))){
                dp[start] = true;
                return true;
            }
        }

        dp[start] = false;
        return false;
    }
}
