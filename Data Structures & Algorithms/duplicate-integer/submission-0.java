class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int i : nums){
            int oldFreq = freqMap.getOrDefault(i, 0);
            if(oldFreq > 0){
                return true;
            }
            freqMap.put(i, oldFreq + 1);
        }

        return false;
    }
}