import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvaluateDivision {

    HashMap<String, Double> hashMapForNodeVal = new HashMap<>();
    HashMap<String, List<String>> hashMapForConnection = new HashMap<>();
    HashMap<String, Integer> visited = new HashMap<>();

    public void update(String key, double multiplier) {
        updateConnection(key, multiplier);
        visited.clear();
    }

    public void updateConnection(String key, double multiplier){
        if (visited.containsKey(key)) return;
        visited.put(key,1);
        double curVal = hashMapForNodeVal.get(key);
        hashMapForNodeVal.put(key, curVal * multiplier);
        if (hashMapForConnection.containsKey(key)) {
            for (String node : hashMapForConnection.get(key)) {
                updateConnection(node, multiplier);
            }
        }
    }

    public boolean check(String leftKey, String rightKey){
        if (leftKey.equals(rightKey)) return true;
        if (checkConnection(leftKey, rightKey)){
            visited.clear();
            return true;
        } 
        visited.clear();
        return false;
    }

    public boolean checkConnection(String key,String target) {
        if (visited.containsKey(key)) return false;
        visited.put(key,1); 
        if (hashMapForConnection.containsKey(key)) {
            for (String connectedKey : hashMapForConnection.get(key)) {
                if (connectedKey.equals(target) || checkConnection(connectedKey,target)) return true;
            }
        }
        return false;
    }

    public void addToHashMapForConnection(String key, String value){
        if (hashMapForConnection.containsKey(key) == false){
            hashMapForConnection.put(key,new ArrayList<>());
        }
        hashMapForConnection.get(key).add(value);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String leftKey = equation.get(0);
            String rightKey = equation.get(1);

            if (hashMapForNodeVal.containsKey(leftKey) == false && hashMapForNodeVal.containsKey(rightKey) == false) {
                hashMapForNodeVal.put(leftKey, values[i]);
                hashMapForNodeVal.put(rightKey, 1.0);
            } else if (hashMapForNodeVal.containsKey(leftKey) && hashMapForNodeVal.containsKey(rightKey) == false) {
                double leftNum = hashMapForNodeVal.get(leftKey);
                hashMapForNodeVal.put(rightKey, leftNum / values[i]);
            } else {
                double leftNum;
                double rightNum = hashMapForNodeVal.get(rightKey);
                if (hashMapForNodeVal.containsKey(leftKey) == false){
                    hashMapForNodeVal.put(leftKey,values[i]*rightNum);
                }
                leftNum = hashMapForNodeVal.get(leftKey);
                double multiplier = (values[i] * rightNum) / leftNum;
                update(leftKey,multiplier);
            }
            addToHashMapForConnection(leftKey, rightKey);
            addToHashMapForConnection(rightKey, leftKey);
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String leftKey = query.get(0);
            String rightKey = query.get(1);
            if (hashMapForNodeVal.containsKey(leftKey) && hashMapForNodeVal.containsKey(rightKey)){
                if (check(leftKey, rightKey)){
                    result[i] = hashMapForNodeVal.get(leftKey) / hashMapForNodeVal.get(rightKey);
                } else {
                    result[i] = -1;
                }
            }
            else{
                result[i] = -1;
            }
        }
        return result;
    }
}
