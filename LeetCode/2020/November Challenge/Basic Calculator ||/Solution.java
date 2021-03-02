import java.util.Stack;

/*
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
*/

/* Stack 한개를 이용한 풀이 */
// 스택에는 숫자들만 넣고 피연산자들을 합하는 방식
class Solution {
    public int calculate(String s) {
        int len = s.length();
        if (s == null || len == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i=0; i<len; i++){
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}