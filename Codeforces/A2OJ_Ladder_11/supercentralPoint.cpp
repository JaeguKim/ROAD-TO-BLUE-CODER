//15min
#include <bits/stdc++.h> 

using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n;
    cin >> n;
    vector<pair<int,int>> vec;
    for (int i=0;i<n;i++){
        int a,b;
        cin >> a >> b;
        vec.push_back(make_pair(a,b));
    }
    
    int res = 0;
    for (int i=0;i<vec.size();i++){
        bool isUp=false,isDown=false,isLeft=false,isRight=false;
        for (int j=0;j<vec.size();j++){
            if (vec[i].first < vec[j].first && vec[j].second == vec[i].second ){
                isRight = true;
            }
            if (vec[i].first > vec[j].first && vec[j].second == vec[i].second){
                isLeft = true;
            }
            if (vec[i].second < vec[j].second && vec[i].first == vec[j].first){
                isUp = true;
            }
            if (vec[i].second > vec[j].second && vec[i].first == vec[j].first){
                isDown = true;
            }
        }
        if (isRight && isLeft && isUp && isDown){
            res+=1;
        }
    }
    cout << res << endl;
    return 0 ;
}