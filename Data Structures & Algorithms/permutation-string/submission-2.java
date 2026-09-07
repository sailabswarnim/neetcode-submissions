class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        int matches = 0;
        for(int i = 0; i < s1.length(); i++){
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(s1Map[i] == s2Map[i]){
                matches++;
            }
        }

        if(matches == 26){
            return true;
        }

        int l = 0;
        int r = s1.length() - 1;

        while(r < s2.length() - 1){
            Character outgoing = s2.charAt(l);
            Character incoming = s2.charAt(r+1);
            s2Map[outgoing-'a']--;
            if(s1Map[outgoing-'a'] == s2Map[outgoing-'a']){
                matches++;
            } else if(s2Map[outgoing-'a'] + 1 == s1Map[outgoing-'a']){
                matches--;
            }
            
            s2Map[incoming-'a']++;

            if(s1Map[incoming-'a'] == s2Map[incoming-'a']){
                matches++;
            } else if(s2Map[incoming-'a'] - 1 == s1Map[incoming-'a']){
                matches--;
            }

            if(matches == 26){
                return true;
            }

            l++;
            r++;
        }

        return false;
    }


}
