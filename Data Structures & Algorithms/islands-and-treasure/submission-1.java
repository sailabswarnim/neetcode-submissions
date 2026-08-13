class Solution {
    // multi source BFS
    public void islandsAndTreasure(int[][] grid) {
        int[][] dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
        Queue<int[]> queue = new LinkedList<>();
        int INF = 2147483647;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i,j,0});
                }
            }
        }

        if(queue.size() == 0){
            return;
        }

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int dis = cell[2];
            for(int[] dir : dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] != INF){
                    continue;
                }

                grid[nr][nc] = 1 + dis;
                queue.add(new int[]{nr,nc, 1 + dis});
            }
        }

        return;
    }
}
