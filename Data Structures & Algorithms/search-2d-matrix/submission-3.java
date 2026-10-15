class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int lo = 0;
        int hi = matrix.length - 1;

        while(lo <= hi){
            row = lo + (hi-lo)/2;

            int rowMin = matrix[row][0];
            int rowMax = matrix[row][matrix[0].length - 1];
            if(rowMin <= target && target <= rowMax){
                break;
            } else if(rowMin > target){
                hi = row - 1;
            } else {
                lo = row + 1;
            }
        }

        if(lo > hi){
            return false;
        }

        lo = 0;
        hi = matrix[0].length - 1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(matrix[row][mid] == target){
                return true;
            } else if(matrix[row][mid] > target){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return false;
    }
}
