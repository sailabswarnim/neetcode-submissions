class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLen = Integer.MIN_VALUE;
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else {
                while(set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
    }
}
