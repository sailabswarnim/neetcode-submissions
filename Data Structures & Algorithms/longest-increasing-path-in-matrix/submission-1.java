// top down
class Solution {
    int ans = Integer.MIN_VALUE;
    int[][] dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
    Integer[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        memo = new Integer[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dfs(matrix, i, j);
            }
        }

        return ans;
    }

    public int dfs(int[][] matrix, int r, int c){
        if(memo[r][c] != null){
            return memo[r][c];
        }

        if(r >= matrix.length || r < 0 || c >= matrix[0].length || c < 0){
            return 0;
        }

        int res = 1;

        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr < matrix.length && nr >= 0 && nc < matrix[0].length && nc >= 0){
                if(matrix[nr][nc] > matrix[r][c]){
                    res = Math.max(res, 1 + dfs(matrix, nr, nc));
                }
            }
        }

        ans = Math.max(ans, res);
        memo[r][c] = res;
        return res;
    }
}
