import java.math.BigInteger;
import java.util.Scanner;

public class JavaBigInteger {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n1 = scan.nextLine();
        String n2 = scan.nextLine();
        BigInteger b1 = new BigInteger(n1);
        BigInteger b2 = new BigInteger(n2);
        BigInteger sum = b1.add(b2);
        BigInteger mult = b1.multiply(b2);
        System.out.println(sum);
        System.out.println(mult);
        scan.close();
    }
}
