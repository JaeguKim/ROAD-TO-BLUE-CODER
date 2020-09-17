import java.util.Scanner;

public class JavaOutputFormatiing {
    public static void main(String[] args) {
            Scanner sc= new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                System.out.print(String.format("%-15s",s1));
                System.out.printf("%03d\n",x);
            }
            System.out.println("================================");
 
    }
}
