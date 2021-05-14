package prob1648;

// inventory length : I
// orders : O
// range of inventory[i] : R
// BCR : O(I)
// SOL : O(I*O), O(I + log(I)*O), O(I + log(R)*I)

import java.util.*;

class Solution {

    int MOD = (int) (Math.pow(10,9)+7);

    public long getCnt(int[] inventory, long k) {
        long cnt = 0;
        for (int i=0;i<inventory.length;i++) {
            if (inventory[i] > k) {
                cnt += inventory[i]-k;
            }
        }
        return cnt;
    }

    public long getCost(int[] inventory, long k) {
        long ans = 0;
        for (int i=0;i<inventory.length;i++) {
            if (inventory[i] > k) {
                ans += (inventory[i]-k)*(k+1+inventory[i])/2%MOD;
                ans %= MOD;
            }
        }
        return ans;
    }

    public int maxProfit(int[] inventory, int orders) {
        long l=0,h=Arrays.stream(inventory).max().getAsInt(),mid = 0;
        int ans;
        while (l <= h) {
            mid = (l+h)/2;
            long cnt = getCnt(inventory,mid);
            if (cnt < orders) h = mid-1;
            else l = mid+1;
        }
        long remain = orders-getCnt(inventory,l);
        ans = (int) (remain*(l%MOD)%MOD+getCost(inventory,l)%MOD)%MOD;
        return ans;
    }
}