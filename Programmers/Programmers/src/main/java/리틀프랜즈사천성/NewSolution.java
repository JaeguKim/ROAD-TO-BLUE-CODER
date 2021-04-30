package 리틀프랜즈사천성;

import java.util.*;

class Solution {

    public String solution(int m, int n, String[] board) {
        char[][] charBoard = new char[m][n];
        List<Character> answerList = new ArrayList<>();
        initializeCharBoard(m, n, charBoard, board);
        int tilesNumber = checkTiles(m, n, charBoard);
        backTracking(tilesNumber,m,n,charBoard,answerList);
        return ((answerList.size() == tilesNumber) ? getString(answerList):"IMPOSSIBLE");
    }

    public void backTracking(int leftTiles, int m, int n, char[][] charBoard, List<Character> answerList) {
        if (leftTiles <= 0) {
            return;
        }
        int toBeRemovedTile = checkRemovability(m,n,charBoard);
        if (toBeRemovedTile > 0) {
            remove(m,n,charBoard,(char)toBeRemovedTile);
            answerList.add((char)toBeRemovedTile);
            backTracking(leftTiles-1,m,n,charBoard,answerList);
        } else {
            return;
        }
    }

    public int checkRemovability(int m, int n, char[][] charBoard) {
        char finalRemover = 'a';
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (charBoard[i][j] == '*') {
                    continue;
                } else if (charBoard[i][j] == '.') {
                    char upperCh = findUpper(m, n, i - 1, j, charBoard);
                    char lowerCh = findLower(m, n, i + 1, j, charBoard);
                    char leftCh = findLeft(m, n, i, j - 1, charBoard);
                    char rightCh = findRight(m, n, i, j + 1, charBoard);
                    if (upperCh != '*' && upperCh != '.' && upperCh == leftCh)
                        finalRemover = findMin(finalRemover, upperCh);
                    // 2: upper meet right
                    if (upperCh != '*' && upperCh != '.' && upperCh == rightCh)
                        finalRemover = findMin(finalRemover, upperCh);
                    // 3: lower meet left
                    if (lowerCh != '*' && lowerCh != '.' && lowerCh == leftCh)
                        finalRemover = findMin(finalRemover, lowerCh);
                    // 4: lower meet right
                    if (lowerCh != '*' && lowerCh != '.' && lowerCh == rightCh)
                        finalRemover = findMin(finalRemover, lowerCh);
                }
                // <Third> I'm a tile and find my partener!
                else {
                    char curCh = charBoard[i][j];
                    if (curCh == findRight(m, n, i, j + 1, charBoard))
                        finalRemover = findMin(finalRemover, curCh);
                    if (curCh == findLower(m, n, i + 1, j, charBoard))
                        finalRemover = findMin(finalRemover, curCh);
                }
            }
        }
        return ((finalRemover == 'a') ? -1 : (int)finalRemover);
    }

    public void remove(int m, int n, char[][] charBoard, char ch) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (charBoard[i][j] == ch)
                    charBoard[i][j] = '.';
            }
        }
    }

    public String getString(List<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (char ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }

    public void initializeCharBoard(int m, int n, char[][] charBoard, String[] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                charBoard[i][j] = board[i].charAt(j);
            }
        }
    }

    public int checkTiles(int m, int n, char[][] charBoard) {
        HashSet<Character> tempSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (charBoard[i][j] != '.' && charBoard[i][j] != '*') {
                    tempSet.add(charBoard[i][j]);
                }
            }
        }
        return tempSet.size();
    }

    public char findRight(int m, int n, int x, int y, char[][] charBoard) {
        while (y < n && charBoard[x][y] == '.') {
            y++;
        }
        return ((y >= n) ? '*' : charBoard[x][y]);
    }

    public char findLeft(int m, int n, int x, int y, char[][] charBoard) {
        while (y >= 0 && charBoard[x][y] == '.') {
            y--;
        }
        return ((y < 0) ? '*' : charBoard[x][y]);
    }

    public char findUpper(int m, int n, int x, int y, char[][] charBoard) {
        while (x >= 0 && charBoard[x][y] == '.') {
            x--;
        }
        return ((x < 0) ? '*' : charBoard[x][y]);
    }

    public char findLower(int m, int n, int x, int y, char[][] charBoard) {
        while (x < m && charBoard[x][y] == '.') {
            x++;
        }
        return ((x >= m) ? '*' : charBoard[x][y]);
    }

    public char findMin(char a, char b) {
        if (a <= b) return a;
        return b;
    }
}
