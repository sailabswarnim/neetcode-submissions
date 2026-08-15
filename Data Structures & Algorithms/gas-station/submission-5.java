class Solution {
    // greedy
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas = 0;
        int totCost = 0;

        for(int i = 0; i < gas.length; i++){
            totGas += gas[i];
            totCost += cost[i];
        }

        if(totCost > totGas){
            return -1;
        }

        int currGas = 0;
        int result = 0;
        for(int i = 0 ; i < gas.length; i++){
            currGas += gas[i] - cost[i];
            if(currGas < 0){
                currGas = 0;
                result = i + 1;
            }
        }

        return result;
    }
}
