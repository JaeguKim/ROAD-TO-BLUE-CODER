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
        int a,b;
        cin >> a >> b;
        int res = (a+b)/3;
        res = min(res,a);
        res = min(res,b);
        cout << res << endl;
    }
    return 0 ;
}