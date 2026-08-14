class Solution {
    // union Find
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);

        for(int i = 0; i < edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];

            if(!uf.merge(node1, node2)){
                return edges[i];
            }
        }

        return new int[2];
    }

    public class UnionFind{
        int[] parent;
        int[] rank;

        UnionFind(int n){
            parent = new int[n + 1];
            rank = new int[n + 1];

            for(int i = 0; i <= n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // path compression
            int find(int x){
                if(parent[x] != x){
                    parent[x] = find(parent[x]);
                }

                return parent[x];
            }

            // merge
            boolean merge(int x, int y){
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
}
