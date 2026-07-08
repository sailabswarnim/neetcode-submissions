class Solution {
    public int countComponents(int n, int[][] edges) {
        // union find
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            uf.union(x, y);
        }

        return uf.getComponents();

    }

    public class UnionFind {
        int[] parent;
        int[] rank;
        int components;

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            components = n;

            for(int i = 0 ; i < n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // path compression
        public int find(int x){
            if(parent[x] == x){
                return x;
            }

            parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(parent[rootX] == parent[rootY]){
                return;
            }

            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            components--;
        }

        public int getComponents(){
            return components;
        }

    }
}
