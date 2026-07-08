class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return (maxArea == Integer.MIN_VALUE) ? 0 : maxArea;
    }

    public int dfs(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return 0;
        }

        if(grid[row][col] == 0){
            return 0;
        }

        int isLandArea = 1;
        grid[row][col] = 0;
        isLandArea += dfs(grid, row + 1, col);
        isLandArea += dfs(grid, row - 1, col);
        isLandArea += dfs(grid, row, col - 1);
        isLandArea += dfs(grid, row, col + 1);

        return isLandArea;
    }
}
