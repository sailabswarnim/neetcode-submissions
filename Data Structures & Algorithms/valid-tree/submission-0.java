class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }

        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }

        return true;
    }

    public class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i<n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x){
            if(parent[x] == x){
                return x;
            }

            parent[x] = find(parent[x]);
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
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            return true;
        }
    }
}
