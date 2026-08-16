class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for(int i = 0; i <= n; i++){
            int j = i;
            int res = 0;
            while(j != 0){
                res++;
                j = j & (j-1);
            }
            result[i] = res;
        }

        return result;
    }
}
