class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] freq = new int[26];
        for(int i = 0 ; i<26; i++){
            freq[i] = 0;
        }
        for(Character c : s.toCharArray()){
            freq[c-'a']++;
        }

        for(Character c : t.toCharArray()){
            if((freq[c-'a']) == 0)
                return false;
            freq[c-'a']--;
        }

        return true;
    }
}
