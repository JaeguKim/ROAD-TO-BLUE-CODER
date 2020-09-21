import java.util.Scanner;

public class JavaStringReverse {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        StringBuffer strBuffer = new StringBuffer(A);
        String reversed = strBuffer.reverse().toString();
        System.out.println(A.equals(reversed)?"Yes":"No");
    }
}
