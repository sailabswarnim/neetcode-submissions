class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        for(int i = 0 ; i < 26; i++){
            freq[i] = 0;
        }

        int right = 0;
        int left = 0;
        int maxWindowLen = 0;
        int currWindowMax = 0;
        int currWindowSize = 0;
        while(right < s.length()){
            currWindowSize = right - left + 1;
            Character c = s.charAt(right);
            freq[c - 'A']++;
            if(freq[c - 'A']  > currWindowMax){
                currWindowMax = freq[c - 'A'];
            }
            if(currWindowSize - currWindowMax <= k){
                maxWindowLen = Math.max(currWindowSize, maxWindowLen);
            } else {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }

        return maxWindowLen;
    }
}

// // [A,A,B,A,B,B,A]
//     r = 0, currWindowSize = 1, currWindowMax = 1, maxWindowLen = 1
//     r = 1, currWindowSize = 2, currWindowMax = 2,  maxWindowLen = 2
//      r = 2, currWindowSize = 3, currWindowMax = 2,  maxWindowLen = 3
//      r = 3, l = 0, currWindowSize = 4, currWindowMax = 3, maxWindowLen = 4
//      r = 4, l = 0, currWindowSize = 5, currWindowMax = 3, maxWindowLen = 4
