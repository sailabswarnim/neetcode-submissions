// Djikstras
class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int ans = Integer.MIN_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        pq.add(new Node(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            ans = Math.max(ans, node.val);
            int r = node.row, c = node.col;
            visited[r][c] = true;
            if(r == rows - 1 && c == cols - 1){
                return ans;
            }

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && !visited[nr][nc]){
                    pq.add(new Node(nr, nc, grid[nr][nc]));
                }
            }
        }

        return Integer.MAX_VALUE;
    }


    public class Node {
        int row;
        int col;
        int val;

        Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
