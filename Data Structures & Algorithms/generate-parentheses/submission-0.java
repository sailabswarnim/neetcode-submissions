class Solution {
    // Backtracing with pruning
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesisRec(n, new StringBuilder(), 0, 0);

        return res;
    }

    public void generateParenthesisRec(int n, StringBuilder curr, int open, int close){
        if((open == close) && (open + close == 2 * n)){
            res.add(curr.toString());
            return;
        }

        if(close > open || (open > n) || (close > n)){
            return;
        }

        // Add open
        curr.append("(");
        generateParenthesisRec(n, curr, open +1, close);
        curr.deleteCharAt(curr.length()-1);

        // Add close
        curr.append(")");
        generateParenthesisRec(n, curr, open, close + 1);
        curr.deleteCharAt(curr.length()-1);

        return;
    }
}
