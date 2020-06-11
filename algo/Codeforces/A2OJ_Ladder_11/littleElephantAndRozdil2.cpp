//TIME : 25min
//생각을 정리하고 코딩하자
#include <bits/stdc++.h>  
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n;
    cin >> n;
    vector<ll> v;
    for (int i=0;i<n;i++){
        ll num; 
        cin >> num;
        v.push_back(num);
    }
    vector<ll> sorted = v;
    sort(sorted.begin(),sorted.end());
    if (sorted[0] == sorted[1])
        cout << "Still Rozdil" << endl;
    else{
        ll minVal = sorted[0];
        int res = 0;
        for (int i=0;i<n;i++){
            if (v[i] == minVal){
                res = i+1;
                cout << res << endl;
                return 0;
            }
        }
    }
}