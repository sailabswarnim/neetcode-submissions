class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        Arrays.sort(hand);

        for(int i = 0; i < hand.length; i++){
            if(map.get(hand[i]) > 0){
                int start = hand[i];
                int end = start + groupSize;
                while(start < end){
                    if(map.containsKey(start) && map.get(start) > 0){
                        map.put(start, map.get(start) - 1);
                    } else {
                        return false;
                    }
                    start++;
                }
            }
        }

        return true;
    }
}
//[1,2,2,3,3,4,4,5]
