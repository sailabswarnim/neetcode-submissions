class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            if(!validRowCol(board[i])) return false;
        }

        for(int j = 0; j < board[0].length; j++){
            char[] cols = new char[board[0].length];
            for(int i = 0; i < board.length; i++){
                cols[i] = board[i][j];
            }
            if(!validRowCol(cols)) return false;
        }

        for(int i = 0; i < 9; i = i + 3){
            for(int j = 0; j < 9; j = j + 3){
                if(!validGrid(board, i, j)) return false;
            }
        }

        return true;
    }

    public boolean validRowCol(char[] row){
        HashSet<Character> set = new HashSet<>();

        for(char num : row){
            if(num == '.') continue;
            if(set.contains(num)){
                return false;
            }
            set.add(num);
        }

        return true;
    }

    public boolean validGrid(char[][] matrix, int gridStartIdxr, int gridStartIdxc){
        HashSet<Character> set = new HashSet<>();

        for(int i = gridStartIdxr; i < gridStartIdxr + 3; i++){
            for(int j = gridStartIdxc; j < gridStartIdxc + 3; j++){
                if(matrix[i][j] == '.') continue;
                if(set.contains(matrix[i][j])){
                    return false;
                }
                set.add(matrix[i][j]);
            }
        }

        return true;
    }
}
