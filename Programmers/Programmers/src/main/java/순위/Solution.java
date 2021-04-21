package 순위;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private int[][] graph = new int[101][101];

    public int solution(int n, int[][] results) {
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;
        }
        for (int k=1;k<=n;k++) {
            for (int i=1;i<=n;i++) {
                for (int j=1;j<=n;j++) {
                    if (graph[i][j] == Integer.MAX_VALUE) {
                        if (graph[i][k] == 1 && graph[k][j] == 1) {
                            graph[i][j] = 1;
                        }
                        if (graph[i][k] == -1 && graph[k][j] == -1) {
                            graph[i][j] = -1;
                        }
                    }
                }
            }
        }
        int answer = 0;
        for (int i=1;i<=n;i++) {
            boolean has_inf = false;
            for (int j=1;j<=n;j++) {
                if (i !=j && graph[i][j] == Integer.MAX_VALUE) {
                    has_inf = true;
                }
            }
            if (has_inf == false) answer++; 
        }
        return answer;
    }
}
