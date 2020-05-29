//재귀를 오르내리면서 시간이 많이 걸리므로, BFS를 사용하기로한다.
#include <bits/stdc++.h>
using namespace std;

int cntOfCell;
int n,m,k;
bool visited[502][502];
char grid[502][502];
vector<pair<int,int>> res;

void bfs(int startRow, int startCol, int listSize){
    queue<pair<int,int>> que;
    que.push(make_pair(startRow,startCol));

    while (que.size()>0){
        int r = que.front().first;
        int c = que.front().second;
        visited[r][c] = true;
        res.push_back(que.front());
        if (res.size() == listSize)
            return;
        if (grid[r+1][c] == '.' && visited[r+1][c] == false)
            que.push(make_pair(r+1,c));
        if (grid[r-1][c] == '.' && visited[r-1][c] == false)
            que.push(make_pair(r-1,c));
        if (grid[r][c+1] == '.' && visited[r][c+1] == false)
            que.push(make_pair(r,c+1));
        if (grid[r][c-1] == '.' && visited[r][c-1] == false)
            que.push(make_pair(r,c-1));
        que.pop();
        }
}

bool checkPairs(int r, int c){
    bool isInList = false;
    for (int i=0; i<res.size(); i++){
        if (res[i].first == r && res[i].second == c){
            isInList = true;
        }
    }
    return isInList;
}

void printResult(){
    if (res.size() > 0){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (grid[i][j] == '.'){
                    if (checkPairs(i,j) == false){
                        grid[i][j] = 'X';
                    }
                }
            }
        }
    }
    for (int i=1; i<=n; i++){
        for (int j=1; j<=m; j++){
            cout << grid[i][j];
        }
        cout << endl;
    }
}

int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m >> k;
    for (int i=0; i<m+2; i++){
        visited[0][i] = true;
        grid[0][i] = '#';
    }
    for (int i=0; i<n; i++){
        string row;
        cin >> row;
        grid[i+1][0] = '#';
        for (int j=0; j<m; j++){
            grid[i+1][j+1] = row[j];
        }
        grid[i+1][m+1] = '#';

        visited[i+1][0] = true;
        for (int j=0; j<m; j++){
            if (row[j] == '.'){
                cntOfCell += 1;
                visited[i+1][j+1] = false;
            }
            else
                visited[i+1][j+1] = true;
        } 
        visited[i+1][m+1] = true;
    }
    for (int i=0; i<m+2; i++){
        grid[n+1][i] = '#';
        visited[n+1][i] = true;
    }

    // for (int i=0; i<n+2; i++){
    //     for (int j=0; j<m+2; j++){
    //         //cout << grid[i][j];
    //         cout << visited[i][j];
    //     }
    //     cout << endl;
    // }

    if (k>0 && cntOfCell > 0){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (grid[i][j] == '.' and visited[i][j] == false){
                    bfs(i,j,cntOfCell-k);
                    if (res.size() == cntOfCell - k){
                        cout << res.size() << endl;
                        printResult();
                    }
                }
            }
        }
    }
    else
        printResult();

}