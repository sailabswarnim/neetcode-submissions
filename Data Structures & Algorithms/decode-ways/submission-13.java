class Solution {
    // Top Down Rec
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return decodeRec(s, 0, dp);
    }

    public int decodeRec(String s, int start, Integer[] dp){
        if(dp[start] != null){
            return dp[start];
        }

        if(s.charAt(start) == '0'){
            dp[start] = 0;
            return 0;
        }

        if(start == s.length() - 1){
            dp[start] = 1;
            return 1;
        }

        if(start == s.length() - 2){
            int ways = 0;
            if(s.charAt(s.length() - 2) == '0'){
                dp[start] = ways;
                return ways;
            } else {
                ways = (s.charAt(start + 1) == '0') ? 0 : 1;
                if(s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(start + 1) < '7')){
                    ways++;
                }
            }
            dp[start] = ways;
            return ways;
        }

        int result = 0; 
        

        result = decodeRec(s, start + 1, dp);
        if(s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(start + 1) < '7')){
            result += decodeRec(s, start + 2, dp);
        }

        dp[start] = result;
        return result;
    }
}
