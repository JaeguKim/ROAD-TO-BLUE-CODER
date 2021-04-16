import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 합이 s보다 크거나 같을때 까지 right++, 최소값 갱신
// 그리고 합이 s보다 작을때 까지 left++, 최소값 갱신
// 반복(left < n && right < n)
// global min 값이 -1로 되있으면 0을 출력
// 아니면 global min 값을 출력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(input);
            int n = Integer.parseInt(tokenizer.nextToken());
            int s = Integer.parseInt(tokenizer.nextToken());
            List<Integer> list = new ArrayList<>();
            tokenizer = new StringTokenizer(br.readLine());
            int total = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(tokenizer.nextToken());
                list.add(num);
                total += num;
            }
            if (total < s)
                bw.write(0 + "\n");
            else {
                int left = 0;
                int right = 0;
                int sum = 0;
                int minVal = -1;
                while (left < n) {
                    if (right < n && sum < s)
                        sum += list.get(right++);
                    else if (sum >= s) {
                        int len = right - left;
                        if (minVal == -1)
                            minVal = len;
                        else
                            minVal = Math.min(len, minVal);
                        sum -= list.get(left++);
                    } 
                    else {
                        break;
                    }
                }
                bw.write(minVal + "\n");
            }
            bw.flush();
        }
    }
}
