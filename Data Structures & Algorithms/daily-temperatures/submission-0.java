class Solution {
    // stack sol
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{temperatures[0], 0});
        int[] result = new int[temperatures.length];
        for(int i = 1; i < temperatures.length; i++){
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                int[] element = stack.pop();
                int index = element[1];
                result[index] = i - index;
            }

            stack.push(new int[]{temperatures[i], i});
        }

        result[result.length - 1] = 0;
        return result;
    }
}
