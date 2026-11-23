class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int threshold = (int) Math.floor(n/3);
        for(Integer key : map.keySet()){
            if(map.get(key) > threshold){
                res.add(key);
            }
        }

        return res;
    }
}