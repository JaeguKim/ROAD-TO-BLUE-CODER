//TIME : 10min
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
    ll n,k;
    cin >> n >> k;
    ll cnt = floor((n+1)/2);
    if (cnt >= k){
        cout << 1LL*2*k-1 << endl;
    }
    else{
        cout << 1LL*2*(k-cnt) << endl;
    }
}