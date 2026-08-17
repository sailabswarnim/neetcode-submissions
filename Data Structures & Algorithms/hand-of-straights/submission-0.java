class Solution {
    // sorting
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);

        HashMap<Integer, Integer> map = new HashMap<>();
        int smallest = Integer.MAX_VALUE;
        for(int i : hand){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        for(int num : hand){
            if(map.get(num) > 0){
                for(int i = num; i < num + groupSize; i++){
                    if(map.containsKey(i) && map.get(i) > 0){
                        map.put(i, map.getOrDefault(i,0) - 1);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

//[1,2,2,3,3,4,4,5]
