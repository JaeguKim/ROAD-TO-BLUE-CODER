package 이공사팔;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    static int N;
    static int[][] map;

    static int maxVal = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N+1][N+1];

        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0,map);
        System.out.println(maxVal);
    }

    static int[][] deepCopy(int[][] map) {
        int[][] map2 = new int[N+1][N+1];
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++)
                System.arraycopy(map[i],1,map2[i],1,N);
        }
        return map2;
    }

    static void dfs(int count, int[][] map) {
        if (count == 5) {
            updateMax(map);
            return;
        }

        for (int i=0;i<4;i++) {
            int[][] nextMap = deepCopy(map);
            move(i,nextMap);
            dfs(count+1,nextMap);
        }
    }

    static List<Integer> sumLine(List<Integer> line) {
        for (int i=0;i<line.size()-1;i++) {
            if (line.get(i).equals(line.get(i+1))) {
                line.set(i,line.get(i)*2);
                line.remove(i+1);
            }
        }
        return line;
    }

    static void updateMax(int[][] map) {
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                maxVal = Math.max(maxVal,map[i][j]);
            }
        }
    }

    static void move(int dir, int[][] map) {
        List<Integer> line = null;
        // U
        if (dir == 0) {
            for (int i=1;i<=N;i++) {
                line = new ArrayList<>();
                for (int j=1;j<=N;j++) {
                    if (map[j][i] != 0) line.add(map[j][i]);
                    map[j][i] = 0;
                }
                line = sumLine(line);
                for (int j=0;j<line.size();j++) {
                    map[j+1][i] = line.get(j);
                }
            }
        }

        if (dir == 1) {
            for (int i=1;i<=N;i++) {
                line = new ArrayList<>();
                for (int j=0;j<N;j++) {
                    if (map[i][N-j]!=0) line.add(map[i][N-j]);
                    map[i][N-j] = 0;
                }
                line = sumLine(line);
                for (int j=0;j<line.size();j++) map[i][N-j] = line.get(j);
            }
        }

        if (dir == 2) {
            for (int i=1;i<=N;i++) {
                line = new ArrayList<>();
                for (int j=N;j>=1;j--) {
                    if (map[j][i] != 0) line.add(map[j][i]);
                    map[j][i] = 0;
                }
                line = sumLine(line);
                for (int j=0;j<line.size();j++) map[N-j][i] = line.get(j);
            }
        }

        if (dir == 3) {
            for (int i=1;i<=N;i++) {
                line = new ArrayList<>();
                for (int j=1;j<=N;j++) {
                    if (map[i][j] != 0) line.add(map[i][j]);
                    map[i][j] = 0;
                }
                line = sumLine(line);
                for (int j=0;j<line.size();j++) map[i][j+1] = line.get(j);
            }
        }
    }
}
