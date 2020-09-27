import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagContentExtractor {
    public static void main(String[] args) {
        String regex = "<(.+)>([^<]+)</\\1>";
        Pattern p = Pattern.compile(regex);

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();
            Matcher m = p.matcher(line);
            boolean flag = false;

            // Write your code here
            while (m.find()) {
                flag = true;
                String content = m.group(2);
                System.out.println(content);
            }
            if (!flag) {
                System.out.println("None");
            }

            testCases--;
        }

        in.close();
    }
}
