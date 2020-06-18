//잘못된 가정을 범해서 문제를 풀지못했다.
//TIME : 31min
#include <bits/stdc++.h>  
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int findMaxRatio(vector<int> a, vector<int> b){
    int maxRatio = -1;
    for (int i=0;i<a.size();i++){
        for (int j=0;j<b.size();j++){
            int ratio = b[j]/a[i];
            if (b[j]%a[i] == 0){
                maxRatio = max(maxRatio,ratio);
            }
        }
    }
    return maxRatio;
}

int main() {
    // #ifndef ONLINE_JUDGE
    // freopen("input.txt", "r", stdin) ;
    // freopen("output.txt", "w", stdout) ;
    // #endif
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n,m;
    vector<int> a,b;
    cin >> n;
    while (n--){
        int num;
        cin >> num;
        a.push_back(num);
    }
    cin >> m;
    while (m--){
        int num;
        cin >> num;
        b.push_back(num);
    }
    int res = 0;
    int maxRatio = findMaxRatio(a,b);
    for (int i=0;i<a.size();i++){
        for (int j=0;j<b.size();j++){
            int ratio = b[j]/a[i];
            if (b[j]%a[i] == 0 && ratio == maxRatio){
                res+=1;
            }
        }
    }
    cout << res << endl;
    return 0 ;
}