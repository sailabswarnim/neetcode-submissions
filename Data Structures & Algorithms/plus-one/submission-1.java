class Solution {
    // One pass with HashMap
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int carry = 1;
        int digit = 0;
        for(int i = n - 1; i >= 0; i--){
            int num = digits[i] + carry;
            carry = num/10;
            digit = num%10;
            map.put(i, digit);
        }

        if(carry == 0){
            for(int i : map.keySet()){
                digits[i] = map.get(i);
            }
            return digits;
        } else {
            int[] result = new int[n+1];
            result[0] = 1;
            return result;
        }
    }
}
