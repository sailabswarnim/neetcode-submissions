class Solution {
    // Top Down
    HashMap<String, Integer> memo;
    public int numDistinct(String s, String t) {
        memo = new HashMap<>();
       return numDistinctRec(s, t, 0, new StringBuilder());
    }

    public int numDistinctRec(String s, String t, int start, StringBuilder res){
        String key = start + "-" + res.toString();
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(res.toString().equals(t)){
            memo.put(key, 1);
            return 1;
        }

        if(start >= s.length()){
            memo.put(key, 0);
            return 0;
        }


        // include
        int include = 0;
        res.append(s.charAt(start));
        include = numDistinctRec(s, t, start + 1, res);

        // exclude
        int exclude = 0;
        res.deleteCharAt(res.length() - 1);
        exclude = numDistinctRec(s, t, start + 1, res);

        memo.put(key, include + exclude);
        return include + exclude;
    }
}
