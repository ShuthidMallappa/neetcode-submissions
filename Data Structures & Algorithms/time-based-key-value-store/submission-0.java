class TimeMap {
    Map<String,ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> list = map.get(key);

        int low =0;
        int high= list.size() - 1;
        String res = "";

        while(low <= high){
            int mid = low + (high - low)/ 2;

            if(list.get(mid).timeStamp <= timestamp){
                res = list.get(mid).value;
                low = mid +1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}

public static class Pair{
    int timeStamp;
    String value;

    public Pair(int timeStamp, String value){
        this.timeStamp = timeStamp;
        this.value = value;
    }
}
