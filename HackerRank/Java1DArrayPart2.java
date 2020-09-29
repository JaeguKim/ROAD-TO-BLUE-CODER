import java.util.HashSet;
import java.util.Scanner;
public class Java1DArrayPart2 {

    public static boolean canWin(int leap, int[] game) {
        HashSet<Integer> visited = new HashSet<>();
        boolean res = helper(0,leap,game,visited);
        return res;
    }

    public static boolean helper(int idx,int leap, int[] game,HashSet<Integer> visited){
        if (idx < 0 || (idx < game.length && game[idx] == 1) || visited.contains(idx)){
            return false;
        }
        else if (idx > game.length-1){
            return true;
        }
        visited.add(idx);
        boolean b1 = helper(idx-1,leap,game,visited);
        boolean b2 = helper(idx+1,leap,game,visited);
        boolean b3 = helper(idx+leap,leap,game,visited);
        return b1 || b2 || b3;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}