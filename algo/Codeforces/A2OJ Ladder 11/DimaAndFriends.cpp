//TIME : 19min 40sec
#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n;
    cin >> n;
    int cntOfPeople = n+1;
    int cntOfFingers = 0;
    int res = 0;
    for (int i=0;i<n;i++){
        int cnt;
        cin >> cnt;
        cntOfFingers += cnt;
    }
    for (int i=1;i<=5;i++){
        int totalFingers = cntOfFingers+i;
        if (totalFingers%cntOfPeople != 1){
            res++;
        }
    }
    cout << res << endl;
    return 0 ;
}