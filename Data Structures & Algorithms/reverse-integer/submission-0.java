class Solution {
    public int reverse(int x) {
        final int MIN = Integer.MIN_VALUE;
        final int MAX = Integer.MAX_VALUE;
        int result = 0;
        while(x != 0){
            int onesPlace = x % 10;
            x /= 10;
           
           if(result > MAX/10 || (result == MAX/10) && (onesPlace > MAX%10)){
                return 0;
           }

           if(result < MIN/10 || (result == MIN/10) && (onesPlace < MIN%10)){
                return 0;
           }

            result = (result * 10) + onesPlace;
        }

        return result;
    }
}
