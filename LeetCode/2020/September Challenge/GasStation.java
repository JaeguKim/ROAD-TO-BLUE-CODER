import java.security.spec.EncodedKeySpec;

class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int i=0; i<n; i++){
            int curGas = gas[i];
            int idx = i;
            boolean flag = true;
            for (int j=0; j<n; j++){
                if (curGas < cost[idx]){
                    flag = false;
                    break;
                }
                else{
                    curGas -= cost[idx];
                    idx = (idx+1)%n;
                    curGas += gas[idx];
                }
            }
            if (flag) return i;
        }
        return -1;
    }
}