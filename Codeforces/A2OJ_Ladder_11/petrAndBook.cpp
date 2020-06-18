//TIME : 34min
//exception case에 대해서 생각
//brute force방법도 유효

#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n;
    cin >> n;
    int arr[10];
    ll prefixSum[10];
    for (int i=1;i<=7;i++){
        cin >> arr[i];
    }
    prefixSum[1] = arr[1];
    for (int i=2;i<=7;i++){
        prefixSum[i] = prefixSum[i-1]+arr[i];
    }

    ll leftPageForLastWeek = n%prefixSum[7];
    int res = 7;
    if (leftPageForLastWeek == 0){
        for (int i=7;i>=1;i--){
            if (arr[i] != 0){
                cout << i << endl;
                return 0;
            }
        }
    }
    for (int i=1;i<=7;i++){
        if (leftPageForLastWeek <= prefixSum[i]){
            res = i;
            break;   
        }
    }
    cout << res << endl;
    /* METHOD 2 */
    /*
    int i = 0;
    ll sum = 0;
    while (true){
        i = i+1;
        if (i > 7)
            i = 1;
        sum+=arr[i];
        if (sum>=n){
            break;
        }
    }
    cout << i << endl;
    */
    return 0 ;
}