import java.util.*;
public class JavaDequeue {

    public static void addDequeAndHashMap(int num, HashMap<Integer,Integer> hashMap,Deque<Integer> deque){
        deque.addLast(num);
        if (hashMap.containsKey(num)){
            hashMap.put(num,hashMap.get(num)+1);
        }
        else {
            hashMap.put(num,1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (deque.size() < m){
                addDequeAndHashMap(num,hashMap,deque);
            }
            else {
                int front = deque.removeFirst();
                hashMap.put(front,hashMap.get(front)-1);
                if (hashMap.get(front) == 0) hashMap.remove(front);
                addDequeAndHashMap(num, hashMap, deque);
            }
            ans = Math.max(hashMap.size(),ans);
        }
        in.close();
        System.out.println(ans);
    }
}




