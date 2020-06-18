#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

char arr[1001][1001];
int rOffset[4] = {-1,0,1,0};
int cOffset[4] = {0,1,0,-1};

void dfs(int r,int c,char prevChar){
    if (r < 1 || r > 1000 || c < 1 || c > 1000 )
        return;
    if (arr[r][c] != '.')
        return;
    arr[r][c] = (prevChar == 'B')?'W':'B';
    for (int i=0;i<4;i++){
        int newR = r+rOffset[i];
        int newC = c+cOffset[i];
        dfs(newR,newC,arr[r][c]);
    }    
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n,m;
    cin >> n >> m;
    
    for (int i=1;i<=n;i++){
        for (int j=1;j<=m;j++){
            cin >> arr[i][j];
        }
    }
    for (int i=1;i<=n;i++){
        for (int j=1;j<=m;j++){
            if (arr[i][j] == '.'){
                dfs(i,j,'B');
            }
        }
    }
    for (int i=1;i<=n;i++){
        for (int j=1;j<=m;j++){
            cout << arr[i][j];
        }
        cout << endl;
    }
    return 0 ;
}