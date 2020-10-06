import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt();
            sc.nextLine();
            int b = sc.nextInt();
            int res = a/b;
            System.out.println(res);
        } catch (InputMismatchException e){
            System.out.println(e.getClass().getName());
        } catch (Exception e){
            System.out.println(e);
        }

        sc.close();
    }
}
