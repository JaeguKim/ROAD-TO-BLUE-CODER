import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Solution {

    public static int getNumberOfSetBits(BitSet b){
        int cnt = 0;
        for (int i=0; i<b.size(); i++){
            if (b.get(i)){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input);
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        BitSet[] bitSets = {null,b1,b2};
        for (int i=0; i<m; i++){
            tokenizer = new StringTokenizer(br.readLine());
            String command = tokenizer.nextToken();
            if (command.equals("AND")){
                int leftOp = Integer.parseInt(tokenizer.nextToken());
                int rightOp = Integer.parseInt(tokenizer.nextToken());
                bitSets[leftOp].and(bitSets[rightOp]);
                bw.write(getNumberOfSetBits(bitSets[1])+" "+getNumberOfSetBits(bitSets[2]));
            }
            if (command.equals("OR")){
                int leftOp = Integer.parseInt(tokenizer.nextToken());
                int rightOp = Integer.parseInt(tokenizer.nextToken());
                bitSets[leftOp].or(bitSets[rightOp]);
                bw.write(getNumberOfSetBits(bitSets[1])+" "+getNumberOfSetBits(bitSets[2]));
            }
            if (command.equals("XOR")){
                int leftOp = Integer.parseInt(tokenizer.nextToken());
                int rightOp = Integer.parseInt(tokenizer.nextToken());
                bitSets[leftOp].xor(bitSets[rightOp]);
                bw.write(getNumberOfSetBits(bitSets[1])+" "+getNumberOfSetBits(bitSets[2]));
            }
            if (command.equals("FLIP")){
                int leftOp = Integer.parseInt(tokenizer.nextToken());
                int idx = Integer.parseInt(tokenizer.nextToken());
                bitSets[leftOp].flip(idx);
                bw.write(getNumberOfSetBits(bitSets[1])+" "+getNumberOfSetBits(bitSets[2]));
            }
            if (command.equals("SET")){
                int leftOp = Integer.parseInt(tokenizer.nextToken());
                int idx = Integer.parseInt(tokenizer.nextToken());
                bitSets[leftOp].set(idx);
                bw.write(getNumberOfSetBits(bitSets[1])+" "+getNumberOfSetBits(bitSets[2]));
            }
            bw.newLine();
            bw.flush();
        }

    }
}