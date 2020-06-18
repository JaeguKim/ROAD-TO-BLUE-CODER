//TIME : 6min
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
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n,m;
    cin >> n >> m;
    int res = 0;
    for (int a=0;a<=1000;a++){
        for (int b=0;b<=1000;b++){
            int r1 = a*a+b;
            int r2 = a+b*b;
            if (r1 == n && r2 == m){
                res +=1;
            }
        }
    }
    cout << res << endl;
}