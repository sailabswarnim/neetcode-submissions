// Top Down Memoised
class Solution {
    String str;
    String ptr;
    HashMap<String, Boolean> memo = new HashMap<>();
    public boolean isMatch(String s, String p) {
        str = s;
        ptr = p;
        return rec(0,0);
    }

    public boolean rec(int s1, int p1){
        String key = s1 + "-" + p1;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(p1 == ptr.length()){
            memo.put(key, s1 == str.length());
            return s1 == str.length();
        }

        boolean result;
        boolean firstMatch = (s1 < str.length()) && ((str.charAt(s1) == ptr.charAt(p1)) || (ptr.charAt(p1) == '.'));

        if(p1 + 1 < ptr.length() && ptr.charAt(p1+1) == '*'){
            result = rec(s1, p1 + 2) || firstMatch && rec(s1 + 1, p1);
        } else {
            result = firstMatch && rec(s1+1, p1+1);
        }
        
        memo.put(key, result);
        return result;
    }
}
