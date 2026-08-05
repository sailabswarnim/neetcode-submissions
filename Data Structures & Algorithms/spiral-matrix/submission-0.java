class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // iterative
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        while(top <= bottom && left <= right){
            // left to right

            if(top <= bottom && left <= right){
                for(int j = left; j <= right; j++){
                    result.add(matrix[top][j]);
                }
                top++;
            }

            // top to bottom
            if(top <= bottom && left <= right){
                for(int i = top; i <= bottom; i++){
                    result.add(matrix[i][right]);
                }
                right--;
            }

             // right to left
            if(top <= bottom && left <= right){
                for(int j = right; j >= left; j--){
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }


            // bottom to top
            if(top <= bottom && left <= right){
                for(int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
