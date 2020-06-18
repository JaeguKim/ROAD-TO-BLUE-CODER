//TIME : 38min
//문제를 잘못이해했고, 두번째는 풀이논리에 문제가 있었다.
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
    int n,k;
    cin >> n >> k;
    map<int,int> myMap;
    vector<int> key;
    while (n--){
        int num;
        cin >> num;
        key.push_back(num);
    }
    int val = key[k-1];
    
    bool isSame = true;
    for (int i=k;i<key.size();i++){
        if (val != key[i])
            isSame = false;
    }   
    if (isSame){
        int res = k-1;
        for (int i=k-2; i>=0;i--){
            if (val == key[i]){
                res = i;
            }
            else{
                break;
            }
        }
        cout << res << endl;
    }
    else{
        cout << -1 << endl;
    }
    return 0 ;
}