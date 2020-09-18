import java.util.Scanner;

public class JavaEndOfFile
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lineNum = 1;
        while (scan.hasNext()){
            String s = scan.nextLine();
            System.out.println(String.format("%d %s",lineNum++,s));
        }
    }
}
