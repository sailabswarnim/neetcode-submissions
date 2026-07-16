class Solution {
    public String longestPalindrome(String s) {
        // two pointer solution

        int resLen = 0, resIdx = 0;
        int right = 0, left = 0;
        for(int i = 0; i < s.length(); i++){
            // odd length Substrings
            right = i;
            left  = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(resLen < right - left + 1){
                    resLen = right - left + 1;
                    resIdx = left;
                }

                right++;
                left--;
            }


            // even length Substrings
            right = i + 1;
            left  = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(resLen < right - left + 1){
                    resLen = right - left + 1;
                    resIdx = left;
                }

                right++;
                left--;
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }
}
