class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++){
            graph.put(i , new ArrayList<>());
        }

        for(int[] pair : edges){
            int a = pair[0];
            int b = pair[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int noOfComponents = 0;
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                dfs(i, graph, visited);
                noOfComponents++;
            }
        }

        return noOfComponents;
    }

    public void dfs(int node, HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited){
        if(visited.contains(node)){
            return;
        }

        visited.add(node);

        for(Integer nbr : graph.get(node)){
            if(!visited.contains(nbr)){
                dfs(nbr, graph, visited);
            }
        }

        return;
    }
}
