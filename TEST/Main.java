import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//input
//n : size
//map
//output
//영역갯수
//각 영역의 크기
//영역의 크기를 오름차순으로 정렬하여 한줄에 출력, 불필요한 공백없이 newline으로 끝나야함

//모든 원소에 대해서 방문하지 않았으면 bfs실행 완료하면 영역의 수를 리턴
//리턴받아서 list에 저장
//정렬하여 출력

class Main {
    
    static int[][] offset = {{0,1},{0,-1},{1,0},{-1,0}};
    static int N = 0;
    static boolean[][] visited;
    static int[][] map;

    private static class Position {
        int row,col;
        public Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private static boolean checkBound(int r,int c){
        if (r < 0 || r > N-1 || c < 0 || c > N-1){
            return false;
        }
        return true;
    }

    static int bfs(int r, int c){
        Queue<Position> que = new LinkedList<>();
        que.add(new Position(r,c));
        int cnt = 1;
        visited[r][c] = true;
        while (que.size() > 0){
            Position front = que.poll();
            for (int i=0; i<4; i++){
                int newR = front.row+offset[i][0];
                int newC = front.col+offset[i][1];
                if (checkBound(newR,newC) && map[newR][newC] == 1 && visited[newR][newC] == false){
                    cnt += 1;
                    visited[newR][newC] = true;
                    que.add(new Position(newR,newC));
                }
            }
        }
        return cnt;
    }


    private static void solution(int sizeOfMatrix, int[][] matrix) {
        N = sizeOfMatrix;
        map = matrix;
        visited = new boolean[sizeOfMatrix][sizeOfMatrix];
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<sizeOfMatrix; i++){
            for (int j=0; j<sizeOfMatrix; j++){
                if (matrix[i][j] == 1 && visited[i][j] == false){
                    res.add(bfs(i,j));
                }
            }
        }
        Collections.sort(res);
        System.out.println(res.size());
        for (int i=0; i<res.size();i++){
            if (i == res.size()-1) System.out.println(res.get(i));
            else System.out.printf(res.get(i)+" ");
        }
    }

    private static class InputData {
        int sizeOfMatrix;
        int[][] matrix;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
            for (int i = 0; i < inputData.sizeOfMatrix; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.sizeOfMatrix; j++) {
                    inputData.matrix[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.sizeOfMatrix, inputData.matrix);
    }
}