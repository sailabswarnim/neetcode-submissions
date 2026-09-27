class Solution {
    // Top Down
    HashMap<String, Boolean> memo = new HashMap<>();
    public boolean checkValidString(String s) {
        return checkValidStringRec(s, 0, 0, 0);
    }

    public boolean checkValidStringRec(String s, int start, int open, int close){
        String key = start + "-" + open + "-" + close;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        boolean result;

        if(start == s.length()){
            result = (open == close) ? true : false;
            memo.put(key, result);
            return result;
        }

        if(close > open){
            result = false;
            memo.put(key, result);
            return false;
        }

        if(s.charAt(start) == '('){
            result = checkValidStringRec(s, start + 1, open + 1, close);
            memo.put(key, result);
            return result;
        }

        if(s.charAt(start) == ')'){
            result = checkValidStringRec(s, start + 1, open, close + 1);
            memo.put(key, result);
            return result;
        }

        result = checkValidStringRec(s, start + 1, open, close) || checkValidStringRec(s, start + 1, open + 1, close) || checkValidStringRec(s, start + 1, open, close + 1);

        memo.put(key, result);
        return result;
    }
}
