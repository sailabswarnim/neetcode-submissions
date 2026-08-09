class Solution {
    // less readable
    public int orangesRotting(int[][] grid) {
        Queue<List<int[]>> queue = new LinkedList<>();
        int noOfMinutes = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        List<int[]> currRottenLevels = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    currRottenLevels.add(new int[]{i,j});
                }
            }
        }

        queue.add(currRottenLevels);
        while(!queue.isEmpty()){
            currRottenLevels = queue.poll();
            List<int[]> nextRottenLevels = new ArrayList<>();
            for(int[] coords : currRottenLevels){
                if(coords[1] + 1 < cols && grid[coords[0]][coords[1] + 1] == 1){
                    grid[coords[0]][coords[1] + 1] = 2;
                    nextRottenLevels.add(new int[]{coords[0], coords[1] + 1});
                }

                if(coords[1] - 1 >= 0 && grid[coords[0]][coords[1] - 1] == 1){
                    grid[coords[0]][coords[1] - 1] = 2;
                    nextRottenLevels.add(new int[]{coords[0], coords[1] - 1});
                }

                if(coords[0] + 1 < rows && grid[coords[0] + 1][coords[1]] == 1){
                    grid[coords[0] + 1][coords[1]] = 2;
                    nextRottenLevels.add(new int[]{coords[0] + 1, coords[1]});
                }

                if(coords[0] - 1 >= 0 && grid[coords[0] - 1][coords[1]] == 1){
                    grid[coords[0] - 1][coords[1]] = 2;
                    nextRottenLevels.add(new int[]{coords[0] - 1, coords[1]});
                }
            }

            if (!nextRottenLevels.isEmpty()) {
                queue.add(nextRottenLevels);
                noOfMinutes++;
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return noOfMinutes;
    }
}
