class Solution {
    // Top Down
    HashMap<String, Boolean> memo = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleaveRec(s1,s2,s3,0,0,0);
    }

    public boolean isInterleaveRec(String s1, String s2, String s3, int i, int j, int k){
        String key = i + "-" + j + "-" + k;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(k == s3.length()){
            memo.put(key, (i == s1.length()) && (j == s2.length()));
            return (i == s1.length()) && (j == s2.length());
        }

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            if(isInterleaveRec(s1,s2,s3,i+1,j,k+1)){
                memo.put(key, true);
                return true;
            }
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            if(isInterleaveRec(s1,s2,s3,i,j+1,k+1)){
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}
