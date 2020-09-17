import java.util.Scanner;

public class JavaLoops2 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();

        for (int i=0; i<q; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int n = scan.nextInt();
            System.out.println(a);
            System.out.println(b);
            System.out.println(n);
            
            int num = a;
            for (int j=0;j<n;j++){
                num += b*Math.pow(2,j);
                if (j == n-1){
                    System.out.printf("%d\n", num);
                }
                else{
                    System.out.printf("%d ",num);
                }
            }   
        }
        scan.close();
    }
}

