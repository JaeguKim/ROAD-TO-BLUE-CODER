import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// input
// n
// n line (-10000,10000)
// output
// maximum sum

// 양수인경우 수를 내림차순으로 소팅하고 큰수부터 2개씩 짝을 지어서 묶은후 더한다
// 음수인경우 수를 오름차순으로 소팅하고 작은수부터 2개씩 짝을 지어서 묶은후 더한다
// 섞여있는경우 음수들끼리 오름차순으로 소팅하고 최대값을 구한다, 양수들끼리 최대값을 구한다, 두 경우를 합한다
// 0인경우 음수와 결합하게 둔다
// **** 1인경우 더하는것이 더유리하다 ****
public class Main {

    static int calcMax(List<Integer> list){
        int sum = 0;
        for (int i=0; i<list.size(); i+=2){
            if (i+1 < list.size()){
                sum += list.get(i)*list.get(i+1);
            }
            else{
                sum += list.get(i);
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        int res = 0;
        while (n-- > 0){
            int num = Integer.parseInt(br.readLine());
            if (num <= 0) negatives.add(num);
            else if (num == 1) res += 1;
            else if (num > 0) positives.add(num);
        }
        Collections.sort(negatives);
        Collections.sort(positives,Collections.reverseOrder());
        res += calcMax(negatives)+calcMax(positives);
        bw.write(res+"\n");
        bw.flush();
    }
}
