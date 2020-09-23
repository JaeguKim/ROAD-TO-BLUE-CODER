import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Java2DArray {

    private static final Scanner scanner = new Scanner(System.in);
    private static int[][] arr;

    public static int getCnt(int r, int c) {
        return arr[r][c] + arr[r][c + 1] + arr[r][c + 2] + arr[r + 1][c + 1] + arr[r + 2][c] + arr[r + 2][c + 1]
                + arr[r + 2][c + 2];
    }

    public static void main(String[] args) {
        arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int ans = 0;
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (flag)
                    ans = Math.max(ans, getCnt(i, j));
                else {
                    ans = getCnt(i, j);
                    flag = true;
                }
            }
        }
        System.out.println(ans);
        scanner.close();
    }
}
