import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// input
// n : 단어갯수
// n줄에서 단어들을 입력받는다
// 최대 단어의 종류는 10가지 이므로 브루트 포스로 풀이가능하다(10! = 3628800)
// hashSet에 현재 존재하는 문자들을 넣는다
// 각각의 key들을 대상으로 가능한 모든 경우의 수를 도출한다

public class Main {

    static List<Character> keys;
    static List<String> input;
    static int res;

    public static void findAllCases(Deque<Character> perm, HashSet<Character> visited, int idx){
        if (idx > keys.size()-1){
            res = Math.max(res,getSum(perm));
            return;
        }
        for (int i=0; i<keys.size(); i++){
            char chr = keys.get(i);
            if (visited.contains(chr)) continue;
            perm.add(chr);
            visited.add(chr);
            findAllCases(perm,visited,idx+1);
            visited.remove(chr);
            perm.pollLast();
        }
    }

    public static int getSum(Deque<Character> perm){
        HashMap<Character,Integer> valueMap = new HashMap<>();
        int cur = 9;
        Iterator<Character> iter = perm.iterator();
        while (iter.hasNext()){
            valueMap.put(iter.next(),cur--);
        }
        int res = 0;
        for (String s : input) {
            int mult = 1;
            for (int i = s.length()-1; i > -1; i--) {
                char ch = s.charAt(i);
                res += mult * valueMap.get(ch);
                mult *= 10;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<Character> hashSet = new HashSet<>();
        input = new ArrayList<>();
        while(n-- > 0){
            String s = br.readLine();
            for (int i=0; i<s.length(); i++){
                hashSet.add(s.charAt(i));
            }
            input.add(s);
        }
        keys = new ArrayList<>();
        Iterator<Character> iter = hashSet.iterator();
        while (iter.hasNext()){
            keys.add(iter.next());
        }
        res = Integer.MIN_VALUE;
        findAllCases(new ArrayDeque<Character>(),new HashSet<Character>(),0);
        bw.write(res+"\n");
        bw.flush();
    }
}