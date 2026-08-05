class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> rowsToBeMarked = new ArrayList<>();
        List<Integer> colsToBeMarked = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rowsToBeMarked.add(i);
                    colsToBeMarked.add(j);
                }
            }
        }

        for(Integer row : rowsToBeMarked){
            markRow(matrix, row);
        }

        for(Integer col : colsToBeMarked){
            markCol(matrix, col);
        }
    }

    public void markCol(int[][] matrix, int col){
        for(int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }
    }

    public void markRow(int[][] matrix, int row){
        for(int j = 0; j < matrix[row].length; j++){
            matrix[row][j] = 0;
        }
    }
}
