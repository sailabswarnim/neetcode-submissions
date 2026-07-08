class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int upperK = Integer.MIN_VALUE;
        for(int pile: piles){
            upperK = Math.max(upperK, pile);
        }

        int lo = 1, hi = upperK;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(eatHours(piles, mid) <= h){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int eatHours(int[] piles, int k){
        int result = 0;
        for(int pile : piles){
            result += Math.ceil((double) pile / k);
        }

        return result;
    }
}
