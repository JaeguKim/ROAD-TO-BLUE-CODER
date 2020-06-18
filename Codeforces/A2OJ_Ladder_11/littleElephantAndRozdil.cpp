//TIME : 25min
//생각을 정리하고 코딩하자
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
    int n;
    cin >> n;
    ll minVal = pow(10,9)+1;
    int minNum = 0;
    int minCnt = 0;
    for (int i=0;i<n;i++){
        ll num; 
        cin >> num;
        if (minVal > num){
            minVal = num;
            minNum = i+1;
            minCnt = 1;
        }
        else if (num == minVal){
            minCnt+=1;
        }
    }
    if (minCnt == 1)
        cout << minNum << endl;
    else
        cout << "Still Rozdil" << endl;
}