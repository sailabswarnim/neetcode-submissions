class Solution {
    public int uniquePaths(int m, int n) {
       //bottom up space optimised

        int[] prevRow = new int[n];
        int[] currRow = new int[n];
        Arrays.fill(prevRow, 1);
        for(int i = m - 2; i >= 0; i--){
            currRow[n-1] = 1;
            for(int j = n-2; j >=0; j--){
                currRow[j] = prevRow[j] + currRow[j+1];
            }
            prevRow = currRow;
        }

        return prevRow[0];
    }
}
