//package 리틀프랜즈사천성;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//class Solution {
//    Set<Character> set = new HashSet<>();
//    List<String> sequence = new ArrayList<>();
//    int M;
//    int N;
//    int[] dx = new int[]{0,1,0,-1};
//    int[] dy = new int[]{1,0,-1,0};
//    char[][] board_ary;
//    Map<Character,Pos> posMap = new HashMap<>();
//
//    class Pos {
//        int r, c;
//        public Pos(int r, int c) {
//            this.r = r;
//            this.c = c;
//        }
//        public boolean checkBound(int n, int m) {
//            return (r >= 1 && r <= n && c >= 1 && c <= m);
//        }
//    }
//
//    public void permutation(Character[] arr, int d, int n, int r) {
//        if (d == r) {
//            String res = "";
//            for (char ch : arr) {
//                res += ch;
//            }
//            sequence.add(res);
//            return;
//        }
//        for (int i=d;i<n;i++) {
//            swap(arr,d,i);
//            permutation(arr,d+1,n,r);
//            swap(arr,d,i);
//        }
//    }
//
//    public void swap(Character[] arr, int d, int i) {
//        char temp = arr[d];
//        arr[d] = arr[i];
//        arr[i] = temp;
//    }
//
//    public Pos bfs(Pos curPos, char ch) {
//        boolean[][] visited = new boolean[M+1][N+1];
//        Queue<Pos> que = new LinkedList<>();
//        que.add(curPos);
//        visited[curPos.r][curPos.c] = true;
//        while (que.size() > 0) {
//            Pos p = que.poll();
//            for (int i=0;i<4;i++) {
//                Pos newPos = new Pos(p.r+dx[i],p.c+dy[i]);
//                if (newPos.checkBound(M,N) && visited[newPos.r][newPos.c] == false) {
//                    if (board_ary[newPos.r][newPos.c] == '.') {
//                        visited[newPos.r][newPos.c] = true;
//                        que.add(newPos);
//                    }
//                    else if (board_ary[newPos.r][newPos.c] == ch) {
//                        return newPos;
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    public void delete(Pos p1, Pos p2) {
//        board_ary[p1.r][p1.c] = '.';
//        board_ary[p2.r][p2.c] = '.';
//    }
//
//    public char[][] copy() {
//        char[][] backup = new char[M+1][N+1];
//        for (int i=1;i<=M;i++) {
//            for (int j=1;j<=N;j++) {
//                backup[i][j] = board_ary[i][j];
//            }
//        }
//        return backup;
//    }
//
//    public String check() {
//        for (String s : sequence) {
//            char[][] backup = copy();
//            if (s.equals("ABCDFGEHI")) {
//                System.out.println("test");
//            }
//            boolean success = true;
//            for (char ch : s.toCharArray()) {
//                Pos from = posMap.get(ch);
//                Pos to = bfs(from,ch);
//                if (to == null) {
//                    success = false;
//                    break;
//                }
//                delete(from,to);
//            }
//            board_ary = backup;
//            if (success) {
//                return s;
//            }
//        }
//        return "IMPOSSIBLE";
//    }
//
//    public String solution(int m, int n, String[] board) {
//        board_ary = new char[m+1][n+1];
//        for (int i=0;i<m;i++) {
//            for (int j=0;j<n;j++) {
//                board_ary[i+1][j+1] = board[i].charAt(j);
//            }
//        }
//        for (int i=1;i<=m;i++) {
//            for (int j=1;j<=n;j++) {
//                char ch = board_ary[i][j];
//                if (ch != '.' && ch != '*') {
//                    set.add(board_ary[i][j]);
//                    posMap.put(board_ary[i][j],new Pos(i,j));
//                }
//            }
//        }
//        this.M = m;
//        this.N = n;
//        Character[] arr = set.stream().collect(Collectors.toList()).toArray(new Character[0]);
//        permutation(arr,0,arr.length,arr.length);
//        Collections.sort(sequence);
//        return check();
//    }
//}