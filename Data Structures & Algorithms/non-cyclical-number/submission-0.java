class Solution {
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        
        HashSet<Integer> seen = new HashSet<>();
        seen.add(n);
        while(true){
            n = sumOfSquares(n);
            if(n==1){
                return true;
            } else if (seen.contains(n)){
                break;
            } else {
                seen.add(n);
            }
        }

        return false;
    }

    public int sumOfSquares(int n){
        int res = 0;

        while(n > 0){
            int onesPlace = n % 10;
            res += Math.pow(onesPlace, 2);
            n /= 10;
        }

        return res;
    }
}

