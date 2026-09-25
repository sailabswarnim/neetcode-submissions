class Solution {
    // Backtracking
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j ++){
                board[i][j] = ".";
            }
        }
        solve(board, 0, n);
        return res;
    }

    public void solve(String[][] board, int r, int n){
        if(r == board.length){
            List<String> temp = new ArrayList<>();
            for(String[] row : board){
                StringBuilder result = new StringBuilder();
                for(String s : row){
                    result.append(s);
                }
                temp.add(result.toString());
            }
            res.add(temp);
            return;
        }

        for(int j = 0; j < n; j++){
            if(isSafe(board, r, j, n)){
                board[r][j] = "Q";
                solve(board, r + 1, n);
                board[r][j] = ".";
            }
        }

        return;
    }

    public boolean isSafe(String[][] board, int r, int c, int n){
        for(int i = 0; i < n; i++){
            if(board[i][c] == "Q"){
                return false;
            }
        }

        for(int j = 0; j < n; j++){
            if(board[r][j] == "Q"){
                return false;
            }
        }

        for(int i = 0 ; i < n ; i++){
            if((r-i >= 0) && (c-i >= 0) && board[r-i][c-i].equals("Q")){
                return false;
            }

            if((r+i < n) && (c + i < n) && board[r+i][c+i].equals("Q")){
                return false;
            }

            if((r+i < n) && (c-i >= 0) && board[r+i][c-i].equals("Q")){
                return false;
            }

            if((r-i >= 0) && (c+i < n) && board[r-i][c+i].equals("Q")){
                return false;
            }
        }

        return true;
    }
}
