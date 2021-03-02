import java.util.Iterator;
import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == ']'){
                String repeated = "";
                while (!st.peek().equals("[")){
                    repeated = st.pop() + repeated;
                }
                st.pop();
                int digit = Integer.parseInt(st.pop());
                String newString = "";
                while (digit-- > 0){
                    newString += repeated;
                }
                st.push(newString);
            }
            else if (Character.isDigit(s.charAt(i))){
                int temp = i;
                String digit = "";
                while (temp < s.length() && Character.isDigit(s.charAt(temp))){
                    digit += Character.toString(s.charAt(temp));
                    temp++;
                }
                i = temp-1;
                st.push(digit);
            }
            else {
                st.push(Character.toString(s.charAt(i)));
            }
        }
        Iterator<String> iter = st.iterator();
        String res = "";
        while (iter.hasNext()){
            res += iter.next();
        }
        return res;
    }
}
