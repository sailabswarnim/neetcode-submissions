class CountSquares {
    HashMap<String, Integer> map;
    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        map.put(key, map.getOrDefault(key,0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0;
        List<int[]> possibleDiagonals = new ArrayList<>();

        for(String key: map.keySet()){
            String[] keys = key.split(",");
            int[] p = new int[] {Integer.parseInt(keys[0]), Integer.parseInt(keys[1])};
            int diff = Math.abs(p[0]-point[0]);
            if(diff !=0 && diff == Math.abs(p[1]-point[1])){
                possibleDiagonals.add(p);
            }
        }

        for(int[] possibleDiagonal : possibleDiagonals){
            int[] p1 = new int[]{point[0], possibleDiagonal[1]};
            int[] p2 = new int[]{possibleDiagonal[0], point[1]};

            String k1 = p1[0] + "," + p1[1];
            String k2 = p2[0] + "," + p2[1];
            String k3 = possibleDiagonal[0] + "," + possibleDiagonal[1];
            if(map.containsKey(k1) && map.containsKey(k2) && map.containsKey(k3)){
                res += map.get(k1) * map.get(k2) * map.get(k3);
            }
        }

        return res;
    }
}
