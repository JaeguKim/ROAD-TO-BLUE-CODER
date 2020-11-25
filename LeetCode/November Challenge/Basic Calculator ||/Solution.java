import java.util.ArrayList;
import java.util.List;

class Solution {
    public int calculate(String s) {
        List<Character> opList = new ArrayList<>();
        List<Integer> operList = new ArrayList<>();
        String oper = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                oper += ch;
            }
            if (i == s.length() - 1 || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (opList.size() > 0
                        && (opList.get(opList.size() - 1) == '*' || opList.get(opList.size() - 1) == '/')) {
                    char lastOp = opList.remove(opList.size() - 1);
                    int oper1 = operList.remove(operList.size() - 1);
                    int oper2 = Integer.parseInt(oper);
                    if (lastOp == '*') {
                        operList.add(oper1 * oper2);
                    } else if (lastOp == '/') {
                        operList.add(oper1 / oper2);
                    }
                } else {
                    operList.add(Integer.parseInt(oper));
                }
                opList.add(ch);
                oper = "";
            }
        }

        int res = 0;
        res = operList.get(0);
        for (int i=0;i<opList.size(); i++){
            char op = opList.get(i);
            if (op == '+'){
                res += operList.get(i+1);
            }
            else if (op == '-'){
                res -= operList.get(i+1);
            }
        }
        return res;
    }
}