//TIME : 13min
#include <bits/stdc++.h>  
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int k;
    cin >> k;
    int t=12;
    vector<int> a;
    while (t--){
        int num;
        cin >> num;
        a.push_back(num);
    }
    sort(a.begin(),a.end(),greater<>());
    int res = 0;
    int sum = 0;
    bool find = false;
    if (k!=0){
        for (int i=0;i<a.size();i++){
            sum += a[i];
            res+=1;
            if (sum >= k){
                find = true;
                break;
            }
        }
        if (!find)
            res = -1;
    }
    cout << res << endl;
    return 0 ;
}