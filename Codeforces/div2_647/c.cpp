#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int t;
    cin >> t;
    while (t--){
        ull n;
        cin >> n;
        ull divisor = 1;
        ull res = 0;
        while (n>=divisor){
            res += (n/divisor);
            divisor *= 2;
        }
        cout << res << endl;
    }
    return 0;
}