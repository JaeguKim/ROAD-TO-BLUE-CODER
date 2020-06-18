#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;
ll res = pow(10,10)+1;
void solve(vector<int> v, int idx, int k,ll mult){
    if (idx == v.size()-1){
        res = min(res,mult);
        return;
    }
    for (int i=1; i<=k; i++){
        if (idx+i <= v.size()-1){
            ll newMult = mult * v[idx+i];
            solve(v,idx+i,k,newMult);
        }
    }
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int N,K;
    cin >> N >> K;
    vector<int> v;
    for (int i=0;i<N;i++){
        int num;
        cin >> num;
        v.push_back(num);
    }
    solve(v,0,K,v[0]);
    res %= 1000000007;
    cout << res << endl;
    return 0 ;
}