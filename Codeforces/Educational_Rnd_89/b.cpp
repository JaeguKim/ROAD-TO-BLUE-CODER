#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {

    // #ifndef ONLINE_JUDGE
    // freopen("input.txt", "r", stdin) ;
    // freopen("output.txt", "w", stdout) ;
    // #endif
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int t;
    cin >> t;
    while (t--){
        int n,x,m;
        cin >> n >> x >> m;
        int left = x, right = x;
        for (int i=0;i<m;i++){
            int newL,newR;
            cin >> newL >> newR;
            if (newL <= right && newR >= left ){
                left = min(left,newL);
                right = max(right,newR);
            }
        }
        int res = right-left+1;
        cout << res << endl;
    }
    return 0 ;
}