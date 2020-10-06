import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 메모리 계산 착각
// 4Byte * 10000 ~= 2^16 Byte = 2^6 KB = 64KB, MB라고 착각함...
// visited 를 사용하느냐 않하느냐에 따라서 답이 되고 안되고 차이가난다.
class Node implements Comparable<Node> {
    int cnt;
    int row;
    int col;

    public Node(int cnt, int row, int col) {
        this.cnt = cnt;
        this.row = row;
        this.col = col;
    }

    @Override
    public int compareTo(Node o) {
        return cnt - o.cnt;
    }
}

public class Main {

    static int INF = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        short[][] dist = new short[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        //HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                dist[i + 1][j + 1] = Short.parseShort(input.substring(j, j + 1));
                dp[i + 1][j + 1] = INF;
            }
        }
        dp[1][1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 1, 1));
        int[][] offset = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!pq.isEmpty()) {
            Node front = pq.poll();
            if (front.row == n && front.col == m) {
                break;
            }
            //String key = String.format("%s%s", front.row, front.col);
            // if (visited.contains(key))
            //     continue;
            // visited.add(key);
            for (int i = 0; i < 4; i++) {
                int newR = front.row + offset[i][0];
                int newC = front.col + offset[i][1];
                if (newR >= 1 && newR <= n && newC >= 1 && newC <= m) {
                    int newCnt = dp[front.row][front.col] + dist[newR][newC];
                    if (newCnt < dp[newR][newC]){
                        dp[newR][newC] = newCnt;
                        pq.add(new Node(newCnt, newR, newC));
                    }
                }
            }

        }
        bw.write(dp[n][m] + "");
        bw.flush();

    }
}
