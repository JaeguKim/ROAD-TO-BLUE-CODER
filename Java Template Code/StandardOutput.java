import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class StandardOutput {

    static void printArray(int[][] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("test");
        bw.flush();
    }
}
