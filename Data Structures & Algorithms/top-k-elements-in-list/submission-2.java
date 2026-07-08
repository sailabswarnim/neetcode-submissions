class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, List<Integer>> freqGrouping = new HashMap<>();
        HashMap<Integer, Integer> countFreq = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int maxFreq = Integer.MIN_VALUE;
        for(int i : nums){
            int freq = countFreq.getOrDefault(i, 0) + 1;
            countFreq.put(i, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        for(Integer i : countFreq.keySet()){
            int freq = countFreq.get(i);
            List<Integer> existingNumbers = freqGrouping.getOrDefault(freq, new ArrayList<>());
            existingNumbers.add(i);
            freqGrouping.put(freq, existingNumbers);
        }

        int numsUsed = 0;
        for(int i = maxFreq; i > 0; i--){
            List<Integer> numbers = freqGrouping.get(i);
            if(numbers == null) continue;
            if(result.size() < k){
                for(Integer num : numbers){
                    if(result.size() < k){
                        result.add(num);
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }

        int[] arrRes = new int[k];
        for(int i = 0; i < k ; i++){
            arrRes[i] = result.get(i);
        }

        return arrRes;
        
    }
}
