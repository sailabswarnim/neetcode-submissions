class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        for(String c : tokens){
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                int c1 = stack.pop();
                int c2 = stack.pop();
                switch(c) {
                    case "+":
                        stack.push(c1 + c2);
                        break;
                    case "-":
                        stack.push(c2 - c1);
                        break;
                    case "*":
                        stack.push(c1 * c2);
                        break;
                    case "/":
                        stack.push(c2 / c1);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        return stack.pop();
    }
}
