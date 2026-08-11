class Solution {
    // binary search 1 pass
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0;
        int r = rows * cols - 1;

        while(l <= r){
            int mid = l + (r-l)/2;

            int midRow = mid / cols;
            int midCol = mid % cols;

            if(matrix[midRow][midCol] == target){
                return true;
            }

            if(matrix[midRow][midCol] > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
