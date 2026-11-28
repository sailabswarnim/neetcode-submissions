class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;

        int lo = 0;
        int hi = people.length - 1;

        while(lo <= hi) {
            if(people[lo] + people[hi] <= limit){
                lo++;
                hi--;
            } else {
                hi--;
            }
            res++;
        }

        return res;
    }
}
// [1,2,2,3,3]