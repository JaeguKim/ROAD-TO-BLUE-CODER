//42min
#include <bits/stdc++.h> 

using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n=5;
    int g[6][6];
    for (int i=0;i<n;i++)
        for (int j=0;j<n;j++)
            cin >> g[i][j];
    int p[6], pans[6], ans = -1, tmp;
    for (int i=0;i<n;i++)
        p[i] = i;
    do
    {
        tmp = g[p[0]][p[1]]+g[p[1]][p[0]]+g[p[1]][p[2]]+g[p[2]][p[1]]+2*(g[p[2]][p[3]]+g[p[3]][p[2]])+2*(g[p[3]][p[4]]+g[p[4]][p[3]]);
        ans = max(tmp,ans);
    } while (next_permutation(p,p+n));
    cout << ans << endl;
    return 0 ;
}