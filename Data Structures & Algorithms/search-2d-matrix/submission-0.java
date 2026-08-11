class Solution {
    // binary seach 2 pass
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        int row = 0;
        while(top <= bottom){
            row = top + (bottom - top)/2;
            if(target == matrix[row][0] || target == matrix[row][cols-1]){
                return true;
            }
            if(target > matrix[row][0] && target < matrix[row][cols-1]){
                break;
            }
            else if(target < matrix[row][0]){
                bottom = row - 1;
            } else {
                top = row + 1;
            }
        }

        if(top > bottom){
            return false;
        }

        while(left <= right){
            int mid = left + (right - left)/2;

            if(matrix[row][mid] == target){
                return true;
            }

            if(matrix[row][mid] > target){
                right = mid - 1;
            } else {
                left  = mid + 1;
            }
        }

        return false;
    }
}
