import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {

       public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> list = new ArrayList<>();
        scan.nextLine();
        String[] input = scan.nextLine().split(" ");
        for (String s : input){
            list.add(Integer.parseInt(s));
        }
        int q = scan.nextInt();
        scan.nextLine();
        for (int i=0;i<q;i++){
            String query = scan.nextLine();
            if (query.equals("Insert")){
                String[] s = scan.nextLine().split(" ");
                int idx = Integer.parseInt(s[0]);
                int val = Integer.parseInt(s[1]);
                if (idx <= list.size())
                    list.add(idx, val);
            }
            else if (query.equals("Delete")){
                int idx = Integer.parseInt(scan.nextLine());
                if (idx < list.size())
                    list.remove(idx);
            }
        }
        for (int i=0;i<list.size(); i++){
            if (i == list.size()-1){
                System.out.printf("%d",list.get(i));
            }
            else
                System.out.printf("%d ",list.get(i));
        }
    }
}