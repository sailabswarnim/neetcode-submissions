class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countFreq = new HashMap<>();
        for(int num : nums){
            countFreq.put(num, countFreq.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            buckets.add(new ArrayList<>());
        }
        for(Integer num : countFreq.keySet()){
            Integer freq = countFreq.get(num);
            buckets.get(freq - 1).add(num);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--){
            List<Integer> numbers = buckets.get(i);
            for(Integer num : numbers){
                if(result.size() < k){
                    result.add(num);
                }
            }
        }

        int[] answer = new int[k];
        for(int i = 0; i < k; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
