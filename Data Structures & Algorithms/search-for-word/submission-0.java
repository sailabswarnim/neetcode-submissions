class Solution {
    // recursive
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                   result = wordSearchRec(board, word, 0, i, j, visited);
                   if(result)
                    return result;
                }
            }    
        }

        return result;
    }

    public boolean wordSearchRec(char[][] board, String word, int currPosition, int row, int col, boolean[][] visited){
        if(currPosition == word.length()){
            return true;
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }

        boolean wordPresent = false;

        if(word.charAt(currPosition) == board[row][col] && !visited[row][col]){
            visited[row][col] = true;
            wordPresent = wordSearchRec(board, word, currPosition + 1, row + 1, col, visited) || wordSearchRec(board, word, currPosition + 1, row - 1, col, visited)
                || wordSearchRec(board, word, currPosition + 1, row, col + 1, visited) || wordSearchRec(board, word, currPosition + 1, row, col - 1, visited);
            visited[row][col] = false;
        }

        return wordPresent;
    }
}
