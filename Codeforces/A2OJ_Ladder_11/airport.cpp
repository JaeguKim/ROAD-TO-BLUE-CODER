//TIME : 20min
#include <bits/stdc++.h>  
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;
int asc[1001];
int desc[1001];
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
    for (int i=0;i<m;i++){
        int a;
        cin >> a;
        asc[a]++;
        desc[a]++;
    }
    int minVal = 0,maxVal = 0;
    for (int i=0;i<n;i++){
        for (int j=1;j<=1000;j++){
            if (asc[j] > 0){
                minVal += j;
                asc[j]-=1;
                asc[j-1]+=1;
                break;
            }
        }
    }       
    for (int i=0;i<n;i++){
        for (int j=1000;j>=1;j--){
            if (desc[j] > 0){
                maxVal += j;
                desc[j] -= 1;
                desc[j-1] += 1;
                break;
            }
        }
    }
    cout << maxVal << " " << minVal << endl;
    return 0 ;
}