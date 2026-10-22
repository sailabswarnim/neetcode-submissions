class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && stack.peek()[1] < temperatures[i]){
                int[] res = stack.pop();
                int idx = res[0];
                int num = res[1];
                result[idx] = i-idx;
            }

            stack.push(new int[]{i, temperatures[i]});
        }

        return result;
    }
}
