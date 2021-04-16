import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// n : 기차의 수, m : 명령의 수
// 1 i x : i번째 x번째에 사람태우기
// 2 i x : i번째 x번째에 사람이하차
// 3 i : 승객들을 한칸씩 뒤로
// 4 i : 승객들을 한칸씩 앞으로
// 좌석기록이 다른 기차만 통과가능
//출력 : 은하수를 건널수 있는 기차의수 

// 한칸씩 뒤로 밀때, 18~0, 0은 0으로
// 한칸씩 앞으로, 1~19, 19는 0으로
// 각각 기차의 좌석정보를 string으로 변환, hashSet에 저장
// hashSet의 size를 출력

public class Main {

    static int[][] map;
    static HashSet<String> hashSet;
    static int n,m;

    public static void moveBack(int trainNo) {
        for (int i=18;i>=0;i--){
            map[trainNo-1][i+1] = map[trainNo-1][i];
        }
        map[trainNo-1][0] = 0;
    }

    public static void moveForward(int trainNo) {
        for (int i=1;i<=19;i++){
            map[trainNo-1][i-1] = map[trainNo-1][i];
        }
        map[trainNo-1][19] = 0;
    }

    public static void makeHash(){
        hashSet = new HashSet<>();
        for (int i=0; i<n; i++){
            String temp = "";
            for (int j=0; j<20; j++){
                temp += Integer.toString(map[i][j]);
            }
            hashSet.add(temp);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        map = new int[n][20];
        for (int i=0; i<m; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(tokenizer.nextToken());
            if (c1 == 1){
                int c2 = Integer.parseInt(tokenizer.nextToken());
                int c3 = Integer.parseInt(tokenizer.nextToken());
                map[c2-1][c3-1] = 1;
            }
            else if (c1 == 2){
                int c2 = Integer.parseInt(tokenizer.nextToken());
                int c3 = Integer.parseInt(tokenizer.nextToken());
                map[c2-1][c3-1] = 0;
            }
            else if (c1 == 3){
                int c2 = Integer.parseInt(tokenizer.nextToken());
                moveBack(c2);
            }
            else if (c1 == 4){
                int c2 = Integer.parseInt(tokenizer.nextToken());
                moveForward(c2);
            }
        }
        makeHash();
        bw.write(hashSet.size()+"\n");
        bw.flush();
    }
}
