class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : chars){
            if (c == '(' || c == '{' || c == '['){
                stack.add(c);
                continue;
            }

            if (stack.isEmpty()){
                return false;
            }
            if (!stack.isEmpty()){
                Character close = stack.pop();
                if (c == ')' && close != '('){
                    return false;
                }

                if (c == '}' && close != '{'){
                    return false;
                }

                if (c == ']' && close != '['){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
