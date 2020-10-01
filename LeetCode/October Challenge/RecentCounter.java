import java.util.HashMap;

class RecentCounter {

    private List<Integer> list;
    private HashMap<Integer,Integer> hashMap;

    public RecentCounter() {
        list = new ArrayList<>();
        hashMap = new HashMap<>();
    }
    
    public int ping(int t) {
        int idx = -1;
        for (int i=t-3000; i<t; i++){
            if (hashMap.containsKey(i)){
                idx = hashMap.get(i);
            }
        }
    }
}
