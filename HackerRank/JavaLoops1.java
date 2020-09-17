import java.util.Scanner;

public class JavaLoops1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i=0; i<10; i++){
            System.out.println(String.format("%d x %d = %d", n,i+1,n*(i+1)));
        }
        scan.close();
    }
}
