// Binary Search
class TimeMap {
    public class Pair {
        String val;
        int time;

        Pair(int time, String val){
            this.val = val;
            this.time = time;
        }

    }

    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
        return;
    }
    
    public String get(String key, int timestamp) {
        List<Pair> timeAndValue = map.get(key);
        if(timeAndValue == null){
            return "";
        }

        int l = 0;
        int r = timeAndValue.size() - 1;
        String result = "";
        while(l <= r){
            int mid = l + (r-l)/2;
            if(timeAndValue.get(mid).time <= timestamp){
                l = mid + 1;
                result =timeAndValue.get(mid).val;
            } else {
                r = mid - 1;
            }
        }
        

        
        return result;
    }
}
