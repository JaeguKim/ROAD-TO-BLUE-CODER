import java.util.Scanner;

public class JavaSubarray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        scan.nextLine();
        String[] input = scan.nextLine().split(" ");
        for (int i=0;i<n;i++){
            array[i] = Integer.parseInt(input[i]);
        }
        int ans = 0;
        for (int i=0;i<n;i++){
            int sum = 0;
            for (int j=i;j<n;j++){
                sum += array[j];
                if (sum < 0){
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
        scan.close();
    }
}
