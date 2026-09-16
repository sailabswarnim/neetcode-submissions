class Solution {
    // dfs 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] state = new int[numCourses];
        Arrays.fill(state, 0);


        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int parent = pair[1];
            int child = pair[0];
            graph.get(parent).add(child);
        }

        for(int i = 0; i < numCourses; i++){
            if(state[i] == 0){
                if(hasCycle(graph, i, state)){
                    return false;
                }
            }
        }

        return true;

    }

    public boolean hasCycle(HashMap<Integer, List<Integer>> graph, int node, int[] state){
        state[node] = 1;

        for(Integer nbr : graph.get(node)){
            if(state[nbr] == 1){
                return true;
            }

            if(state[nbr] == 2){
                continue;
            }
        
            if(hasCycle(graph, nbr, state)){
                return true;
            }
        }

        state[node] = 2;
        return false;
    }
}
