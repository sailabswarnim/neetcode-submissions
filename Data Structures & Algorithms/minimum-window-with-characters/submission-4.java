class Solution {
    // optimised
    public String minWindow(String s, String t) {
        String minString = "";
        int globalWindowmin = Integer.MAX_VALUE;
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(Character c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c,0) + 1);
        }
        int uniqueCharReq = tMap.keySet().size();
        HashMap<Character, Integer> currMap = new HashMap<>();
        int currCharacters = 0;
        int l = 0, r = 0;
        while(r < s.length()){
            Character c = s.charAt(r);
            currMap.put(c, currMap.getOrDefault(c,0) + 1);
            if(tMap.containsKey(c) && tMap.get(c).equals(currMap.get(c))){
                currCharacters++;
            }  
            while(uniqueCharReq == currCharacters && l <= r){
                int currWindowLen = r - l + 1;
                if(currWindowLen < globalWindowmin){
                    minString = s.substring(l, r + 1);
                    globalWindowmin = currWindowLen;
                }
                Character outgoingChar = s.charAt(l);
                currMap.put(outgoingChar, currMap.get(outgoingChar) - 1);
                if(tMap.containsKey(outgoingChar) && tMap.get(outgoingChar) > currMap.get(outgoingChar)){
                    currCharacters--;
                }
                l++;
            }
            r++;
        }

        return minString;
    }
}
