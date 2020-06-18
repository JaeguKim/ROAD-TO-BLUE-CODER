//TIME : 15min
//min값을 update 하지않아서 시간이 지체됨
#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin) ;
    freopen("output.txt", "w", stdout) ;
    #endif
    cout << "hello" << endl;
    int n;
    cin >> n;
    vector<int> v;
    for (int i=0;i<n;i++){
        int h;
        cin >> h;
        v.push_back(h);
    }
    int first = 1, second=n;
    int minH = abs(v[second-1]-v[first-1]);
    for (int i=0;i<n-1;i++){
        int diff = abs(v[i]-v[i+1]);
        if (diff < minH){
            first = i+1; second = i+2;
            minH = diff;
        }
    }
    cout << first << " " << second << endl;
    return 0 ;
}