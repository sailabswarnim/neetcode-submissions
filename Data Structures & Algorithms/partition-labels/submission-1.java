class Solution {
    // Greedy
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastPosMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            lastPosMap.put(s.charAt(i), i);
        }

        System.out.println(lastPosMap);

        List<Integer> result = new ArrayList<>();
        int partStart = 0;
        while(partStart < s.length()){
            int currEnd = lastPosMap.get(s.charAt(partStart));
            int partEnd = currEnd;
            
            
            for(int i = partStart; i <= currEnd; i++){
                partEnd  = Math.max(partEnd, lastPosMap.get(s.charAt(i)));
            }

            while(partEnd != currEnd) {
                partEnd  = Math.max(partEnd, lastPosMap.get(s.charAt(currEnd)));
                currEnd++;
            }

            result.add(partEnd - partStart + 1);
            partStart = partEnd + 1;
        }

        return result;
    }
}
