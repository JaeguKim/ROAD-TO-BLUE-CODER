import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int count = -1;
    static int target = 0;
    
    public static long getNum(int len, int digit,long prevNum,int newNum){
        if (digit == 0){
            count++;
            if (count == target){
                return prevNum;
            }
            return -1;
        }
        for (int i=0;i<newNum;i++){
            if (len > 1 && digit == len && i == 0){
                continue;
            }
            long res = getNum(len,digit-1,prevNum*10+i,i);
            if (res != -1){
                return res;
            }
        }
        return -1;
    } 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        target = Integer.parseInt(br.readLine());
        if (target > 1022){
            bw.write(-1+"\n");
            bw.flush();
            return;
        }
        int digit = 1;
        long res = -1;
        while (res == -1){
            res = getNum(digit,digit,0,10);
            digit+=1;
        }
        bw.write(res+"\n");
        bw.flush();
    }
}
