class Solution {
    // bottom up
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m+n != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[m+1][n+1];
        for(int i = 0; i <= m; i++){
            dp[i][n] = (s1.substring(i, m).equals(s3.substring(i + n, s3.length())));
        }

        for(int j = 0; j <= n; j++){
            dp[m][j] = (s2.substring(j, n).equals(s3.substring(j + m, s3.length())));
        }

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(s1.charAt(i) == s3.charAt(i+j) && dp[i+1][j]){
                    dp[i][j] = true;
                } else if (s2.charAt(j) == s3.charAt(i+j) && dp[i][j+1]){
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[0][0];
    }
}
