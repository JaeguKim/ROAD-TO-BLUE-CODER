package N으로표현;

public class Solution {

    int result = -1;
    int[] nnn;


    public int solution(int N, int number) {
        nnn = new int[8];
        for (int i=0; i<8; i++) {
            nnn[i] = Integer.parseInt(Integer.toBinaryString((int)Math.pow(2,i+1)-1))*N;
        }
        dfs(0,0,number);
        return result;
    }

    public void dfs(int count, int num, int number) {
        if (count > 8) return;
        if (num == number) {
            if (count < result || result == -1) {
                result = count;
            }
            return;
        }
        for (int i=0;i<8;i++) {
            int NN = nnn[i];
            int countN = i+1;
            dfs(count+countN,num+NN,number);
            dfs(count+countN,num-NN,number);
            dfs(count+countN,num*NN,number);
            dfs(count+countN,num/NN,number);
        }
    }
}
