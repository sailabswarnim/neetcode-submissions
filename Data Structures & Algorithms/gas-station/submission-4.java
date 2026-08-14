class Solution {
    // two pointer
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(cost).sum() > Arrays.stream(gas).sum()){
            return -1;
        }
        int start = gas.length - 1;
        int end = 0;
        int currGas = gas[start] - cost[start];
        while(start > end){
            if(currGas < 0){
                start--;
                currGas += gas[start] - cost[start];
            } else {
                currGas += gas[end] - cost[end];
                end++;
            }
        }

        return start;

    }
}
