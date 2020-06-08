//잘못된 풀이를 떠오열러서 시간이 많이 걸림
#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int arr[101][101];
int n,m;

void erase(int row, int col){
    int cnt = 0;
    for (int i=1; i<=n; i++){
        if (arr[i][col] == 0){
            arr[i][col] = -1;
        }
    }
    for (int i=1; i<=m; i++){
        if (arr[row][i] == 0){
            arr[row][i] = -1;
        }
    }
}

bool findZero(){
    for (int i=1;i<=n;i++){
        for (int j=1;j<=m;j++){
            if (arr[i][j] == 0){
                erase(i,j);
                return true;
            }
        }
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int t; 
    cin >> t;
    while (t--){
        cin >> n >> m;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                cin >> arr[i][j];
            }
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if (arr[i][j] == 1){
                    erase(i,j);
                }
            }
        }
        bool isAshish = false;
        while (true){
            isAshish = !isAshish;
            if (!findZero())
                break;
        }
        if (isAshish){
            cout << "Vivek" << endl;
        }
        else{
            cout << "Ashish" << endl;
        }
    }

    return 0 ;
}