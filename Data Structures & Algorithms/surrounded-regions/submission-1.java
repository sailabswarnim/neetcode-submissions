class Solution {
    int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;
        for(int j = 0; j < cols; j++){
            if(board[0][j] == 'O'){
                dfsMark(board, 0, j);
            }
        }

        for(int j = 0; j < cols; j++){
            if(board[rows - 1][j] == 'O'){
                dfsMark(board, rows - 1, j);
            }
        }

        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O'){
                dfsMark(board, i, 0);
            }
        }

        for(int i = 0; i < rows; i++){
            if(board[i][cols - 1] == 'O'){
                dfsMark(board, i, cols - 1);
            }
        }


        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfsMark(char[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' || board[row][col] == '#'){
            return;
        }

        board[row][col] = '#';

        for(int[] dir : dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];

            dfsMark(board, nr, nc);
        }      
    }
}
