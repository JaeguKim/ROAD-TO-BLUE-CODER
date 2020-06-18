//42min
#include <bits/stdc++.h> 

using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int t,sx,sy,ex,ey;
    cin >> t >> sx >> sy >> ex >> ey;
    string winds;
    cin >> winds;
    int xOffset = ex-sx;
    int yOffset = ey-sy;
    map<int,char> xDir = {{1,'E'},{-1,'W'}};
    map<int,char> yDir = {{1,'N'},{-1,'S'}};
    map<char,int> myMap;
    if (xOffset != 0)
        myMap[xDir[xOffset/abs(xOffset)]] = abs(xOffset);
    if (yOffset != 0)
        myMap[yDir[yOffset/abs(yOffset)]] = abs(yOffset);

    int res = -1;
    for (int i=0;i<winds.length();i++){
        if (myMap.count(winds[i]) != 0){
            myMap[winds[i]]-=1;
            if (myMap[winds[i]] == 0){
                myMap.erase(winds[i]);
            }
            if (myMap.size() == 0){
                res = i+1;
                break;
            }
        }
    }
    if (xOffset == 0 && yOffset == 0){
        res = 0;
    }
    cout << res << endl;
    return 0 ;
}