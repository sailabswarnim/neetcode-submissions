class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegrees = new HashMap<>();
        Queue<Integer> sources = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
            inDegrees.put(i, 0);
        }

        for(int[] pair : prerequisites){
            int parent = pair[1];
            int child = pair[0];
            graph.get(parent).add(child);
            inDegrees.put(child, inDegrees.get(child) + 1);
        }

        for(int course : inDegrees.keySet()){
            if(inDegrees.get(course) == 0){
                sources.add(course);
            }
        }

        int processedCourses = 0;
        while(!sources.isEmpty()){
            int course = sources.poll();
            processedCourses++;

            for(int nbr : graph.get(course)){
                inDegrees.put(nbr, inDegrees.get(nbr) - 1);
                if(inDegrees.get(nbr) == 0){
                    sources.add(nbr);
                }
            }
        }

        return processedCourses == numCourses;

    }
}
