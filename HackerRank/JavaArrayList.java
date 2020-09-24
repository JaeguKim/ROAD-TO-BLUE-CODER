import java.util.ArrayList;
import java.util.Scanner;

public class JavaArrayList {

    public static void printString(String[] input){
        System.out.println("===========");
        for (String s : input){
            System.out.println(s);
        }
        System.out.println("===========");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); 
        ArrayList<ArrayList<Integer>> aryList = new ArrayList<>();
        scan.nextLine();
        for (int i=0;i<n;i++){
            String[] input = scan.nextLine().split(" ");
            aryList.add(new ArrayList<>());
            for (int j=1;j<input.length; j++){
                aryList.get(i).add(Integer.parseInt(input[j]));
            }
        }
        int q = scan.nextInt();
        scan.nextLine();
        for (int i=0;i<q;i++){
            String[] s = scan.nextLine().split(" ");

            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            if (r > aryList.size()){
                System.out.println("Error!");
            }
            else if (c > aryList.get(r-1).size()){
                System.out.println("Error!");
            }
            else {
                System.out.println(aryList.get(r-1).get(c-1));
            }
        }        
        scan.close();
    }
}
