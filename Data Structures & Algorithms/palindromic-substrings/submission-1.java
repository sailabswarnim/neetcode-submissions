class Solution {
    public int countSubstrings(String s) {
        // two pointer solution

        int n = s.length();
        int result = 0, left = 0, right = 0;
        for(int i = 0; i < n; i++){
            // odd substrings
            left = i;
            right = i;
            while(right < n && left >= 0 && s.charAt(left) == s.charAt(right)) {
                result++;
                right ++;
                left --;
            }

            // even substrings
            left = i;
            right = i + 1;
            while(right < n && left >= 0 && s.charAt(left) == s.charAt(right)) {
                result++;
                right ++;
                left --;
            }
        }

        return result;
    }
}
