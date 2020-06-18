//permutation index를 잘 못 생각했다.
#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n;
    cin >> n;
    cout << n;
    for (int i=1;i<n;i++){
        cout << " " << i;
    }
    cout << endl;
    return 0 ;
}