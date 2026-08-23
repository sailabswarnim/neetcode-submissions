// Kruskal's
public class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);      
        }

        return parent[x];
    }

    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY){
            return false;
        }

        if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
            rank[rootX]++;
        } else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }

        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int[] x = points[i];
                int[] y = points[j];
                int dis = Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
                edges.add(new int[]{dis, i, j});
            }
        }

        Collections.sort(edges, (a,b) -> a[0]-b[0]);
        UnionFind uf = new UnionFind(points.length);
        int minCost = 0;
        for(int[] edge : edges){
            if(uf.union(edge[1], edge[2])){
                minCost += edge[0];
            }
        }

        return minCost;
    }
}
