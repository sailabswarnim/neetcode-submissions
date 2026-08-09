class Solution {
    // readable
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
        Queue<List<int[]>> queue = new LinkedList<>();
        int noOfMinutes = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        List<int[]> currRottenLevels = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    currRottenLevels.add(new int[]{i,j});
                }

                if(grid[i][j] == 1){
                   freshCount++;
                }
            }
        }


        if(freshCount == 0){
            return 0;
        }

        queue.add(currRottenLevels);
        while(!queue.isEmpty()){
            currRottenLevels = queue.poll();
            List<int[]> nextRottenLevels = new ArrayList<>();

            for(int[] coords : currRottenLevels){

                for(int[] dir : directions){
                    int nr = coords[0] + dir[0];
                    int nc = coords[1] + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < rows && nc < cols){
                        if(grid[nr][nc] == 1){
                            grid[nr][nc] = 2;
                            nextRottenLevels.add(new int[]{nr, nc});
                            freshCount--;
                        }
                    }
                }
            }

            if (!nextRottenLevels.isEmpty()) {
                queue.add(nextRottenLevels);
                noOfMinutes++;
            }
        }

        return (freshCount == 0) ? noOfMinutes : -1;
    }
}
