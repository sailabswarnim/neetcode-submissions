class Solution {
    // dfs
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];
         List<List<Integer>> answer = new ArrayList<>();
        for(int col = 0; col < heights[0].length; col++){
            dfs(heights, pacific, 0, col);
            dfs(heights, atlantic, ROWS - 1, col);
        }

        for(int row = 0; row < heights.length; row++){
            dfs(heights, pacific, row, 0);
            dfs(heights, atlantic, row, COLS - 1);
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    answer.add(List.of(i, j));
                }
            }
        }

        return answer;
    }
    public void dfs(int[][] heights, boolean[][] ocean, int row, int col) {
        ocean[row][col] = true;

        for(int[] d : directions){
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr >= 0 && nr < heights.length && nc >=0 && nc < heights[0].length 
                && !ocean[nr][nc] && heights[nr][nc] >= heights[row][col]){
                    dfs(heights, ocean, nr, nc);
            }
        }
    }
}
