class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashSet<Integer> visited = new HashSet<>();
        int maxTimeForAnyNode = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));
        // (a) -> a[0] = node , a[1] = minTime from source Node;
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 1; i <= n; i++){
            graph.putIfAbsent(i, new ArrayList<>());
        }

        for(int[] edge : times){
            int node = edge[0];
            int nbr = edge[1];
            int time = edge[2];
            graph.get(node).add(new int[]{nbr, time});
        }
        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] edge = pq.poll();
        

            int node = edge[0];
            int time = edge[1];

            if(visited.contains(node)){
                continue;
            }

            maxTimeForAnyNode = Math.max(maxTimeForAnyNode, time);
            visited.add(node);

            if (visited.size() == n) {
                break;
            }

            for(int[] nbrAndTime : graph.get(node)){
                int nbr = nbrAndTime[0];
                int nbrTime = time + nbrAndTime[1];
                if(!visited.contains(nbr)){
                     pq.add(new int[]{nbr, nbrTime});
                }
            }

        }
        return (visited.size() == n) ? maxTimeForAnyNode : -1;
    }
}
