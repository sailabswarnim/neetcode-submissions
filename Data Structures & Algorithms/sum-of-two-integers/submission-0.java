// Bit manipulation
class Solution {
    public int getSum(int a, int b) {
        int carry = (a & b) << 1;
        int sum = a ^ b;
        while(carry != 0){
            int temp = (sum & carry) << 1;
            sum = sum ^ carry;
            carry = temp;
        }

        return sum;
    }
}
