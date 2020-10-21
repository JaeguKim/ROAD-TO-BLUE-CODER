import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
// hashmap에 자릿수별 문자들을 보관
// 자릿수가 8부터 시작해서 1부터 보면서
// 해당 자릿수에 해당하는 수보다 작은자리에서 발견된 인덱스와 문자를 조합하여 pq에 추가
// pq가 빌때까지 차례대로 빼면서 이미 문자값이 세팅되어있으면 그 값으로 계산,아니면 문자의 정보를 할당하고 할당하면서 합을 계산한다.
public class Main {

    public static IdxInfo getIndexInfo(String s, int idx){
        char ch = s.charAt(idx);
        List<Integer> prevIdxes = new ArrayList<>();
        for (int i=idx-1; i>-1; i--){
            if (ch == s.charAt(i)){
                prevIdxes.add(i);
            }
        }
        return new IdxInfo(ch,prevIdxes);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer,PriorityQueue<IdxInfo>> hashMap = new HashMap<>();
        HashMap<Character,Integer> valueMap = new HashMap<>();
        while(n-- > 0){
            StringBuilder sb = new StringBuilder(br.readLine());
            String reversedStr = sb.reverse().toString();
            for (int i=0; i<reversedStr.length(); i++){
                if (!hashMap.containsKey(i+1)) hashMap.put(i+1,new PriorityQueue<>());
                hashMap.get(i+1).add(getIndexInfo(reversedStr,i));
            }
        }

        int res = 0;
        int curMax = 9;
        for (int place = 8; place >= 1; place--){
            if (hashMap.containsKey(place)){
                PriorityQueue<IdxInfo> pq = hashMap.get(place);
                while (!pq.isEmpty()){
                    IdxInfo front = pq.poll();
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
