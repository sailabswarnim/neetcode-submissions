// Hierholzer's Algorithm (Recursion)
class Solution {
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
        }

        for(List<String> ticket : tickets){
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs(graph, "JFK");
        Collections.reverse(result);
        return result;
    }

    public void dfs(HashMap<String, PriorityQueue<String>> graph, String source){
        PriorityQueue<String> queue = graph.get(source);
    
        while((queue != null) && (!queue.isEmpty())){
            String nbr = queue.poll();
            dfs(graph, nbr);
        }

        result.add(source);
    }
}
