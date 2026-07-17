class Solution {
    // dp bottom up
    public int numDecodings(String s) {
        int n = s.length();
        if(n==1){
            return (s.charAt(0) == '0') ? 0 : 1;
        }
        int[] dp = new int[n];
        dp[n-1] = (s.charAt(n-1) == '0') ? 0 : 1;
        if(s.charAt(n-2) == '0'){
            dp[n-2] = 0;
        } else {
            // single character
            dp[n-2] = dp[n-1];

            // two characters
            if(s.charAt(n-2) == '1' || (s.charAt(n-2) == '2' && s.charAt(n-1) < '7')){
                dp[n-2] += 1;
            }
        }
        for(int i = n-3; i >= 0; i--){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
            } else {
                // single character
                dp[i] = dp[i+1];

                // two characters
                if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7')){
                    dp[i] += dp[i+2];
                }
            }
        }

        return dp[0];
    }
}
