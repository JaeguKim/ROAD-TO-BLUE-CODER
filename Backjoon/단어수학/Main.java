import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class IdxInfo implements Comparable<IdxInfo>{
    char alpha;
    List<Integer> lastIdxes;

    public IdxInfo(char alpha,List<Integer> lastIdxes){
        this.alpha = alpha;
        this.lastIdxes = lastIdxes;
    }

    // 두개의 값이 같으면 둘다증가
    // 둘중에 현재값이 더크면 -1
    // 뒤값이 더크면 1
    // 바운더리가 둘다 넘어가면 0, 현재만 넘어가면 1, 뒤에것만 넘어가면 -1
    @Override
    public int compareTo(IdxInfo o) {
        int first = 0;
        int second = 0;
        while (true){
            if (first > lastIdxes.size()-1 && second > o.lastIdxes.size()-1) return 0;
            else if (first > lastIdxes.size()-1)  return 1;
            else if (second > o.lastIdxes.size()-1) return -1;
            if (lastIdxes.get(first) > o.lastIdxes.get(second)) return -1;
            else if (lastIdxes.get(first) < o.lastIdxes.get(second)) return 1;
            else{
                first++; second++;
            }
        }
    }
    
}

// input
// n : 단어갯수
// n줄에서 단어들을 입력받는다
// hashmap에 자릿수별 숫자들을 보관
// 자릿수가 8부터 시작해서 1부터 보면서
// 해당 자릿수에 있는 문자들중 작은자리에서 같은문자가 발생하는 지점의 수가 큰수부터 정보를 할당하면서 합을 계산한다.

public class Main {

    static HashMap<Integer,HashSet<Character>> chrHashMap;

    public static IdxInfo getIndexInfo(char chr, int place){
        List<Integer> prevIdxes = new ArrayList<>();
        for (int i=place-1; i>=1; i--){
            if (chrHashMap.get(i).contains(chr)){
                prevIdxes.add(i);
            }
        }
        return new IdxInfo(chr,prevIdxes);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        chrHashMap = new HashMap<>();
        HashMap<Integer,PriorityQueue<IdxInfo>> hashMap = new HashMap<>();
        HashMap<Character,Integer> valueMap = new HashMap<>();
        List<String> input = new ArrayList<>();
        while(n-- > 0){
            StringBuilder sb = new StringBuilder(br.readLine());
            String reversedStr = sb.reverse().toString();
            for (int i=0; i<reversedStr.length(); i++){
                if (!chrHashMap.containsKey(i+1)) chrHashMap.put(i+1,new HashSet<>());
                chrHashMap.get(i+1).add(reversedStr.charAt(i));
            }
            input.add(reversedStr);
        }

        for (String s : input){
            for (int i=0; i<s.length(); i++){
                if (!hashMap.containsKey(i+1)) hashMap.put(i+1,new PriorityQueue<>());
                hashMap.get(i+1).add(getIndexInfo(s.charAt(i),i+1));
            }
        }

        int res = 0;
        int curMax = 9;
        for (int place = 8; place >= 1; place--){
            if (hashMap.containsKey(place)){
                PriorityQueue<IdxInfo> pq = hashMap.get(place);
                while (!pq.isEmpty()){
                    IdxInfo front = pq.poll();
                    // System.out.println(front.alpha);
                    // for (int idx : front.lastIdxes){
                    //     System.out.printf("%d ",idx);
                    // }
                    // System.out.println();
                    if (valueMap.containsKey(front.alpha)){
                        res += Math.pow(10,place-1)*valueMap.get(front.alpha);
                    }
                    else {
                        valueMap.put(front.alpha,curMax--);
                        res += Math.pow(10,place-1)*valueMap.get(front.alpha);
                    }

                }
            }
        }
        bw.write(res+"\n");
        bw.flush();
    }
}
