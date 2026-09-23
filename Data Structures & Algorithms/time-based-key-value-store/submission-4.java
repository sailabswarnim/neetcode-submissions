// brute force
class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
        return ;
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeAndValue = map.get(key);
        if(timeAndValue == null){
            return "";
        }

        int timeLessThanTimestamp = 0;
        for(Integer time : timeAndValue.keySet()){
            if(time > timestamp){
                break;
            }
            timeLessThanTimestamp = time;
        }

        
        return (timeAndValue.get(timeLessThanTimestamp) == null) ? "" : timeAndValue.get(timeLessThanTimestamp);
    }
}
