// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//양수이면 5보다작은수 앞에 넣는다, 그거나 같으면 스킵, 너 스킵할수없으면 거기 넣는다
//음수이면 5보다큰수 앞에 넣는다, 작거나 같으면 스킵, 더 스킵할수없으면 거기 넣는다
//특정인덱스에 삽입하는 함수

class Solution {

    public static String insertString( 
        String originalString, 
        String stringToBeInserted, 
        int index) 
    { 
        String newString = originalString.substring(0, index + 1) 
                           + stringToBeInserted 
                           + originalString.substring(index + 1); 
        return newString; 
    } 

    public int solution(int N) {
        String s = Integer.toString(N);
        int res = 0;
        boolean flag = false;
        if (N >= 0){
            for (int i=0; i<s.length(); i++){
                int num = Character.getNumericValue(s.charAt(i));
                if (num < 5){
                    String newString = insertString(s,"5",i-1);
                    res = Integer.parseInt(newString);
                    flag = true;
                    break;
                }
            }
        }
        else {
            for (int i=1; i<s.length(); i++){
                int num = Character.getNumericValue(s.charAt(i));
                if (num > 5){
                    String newString = insertString(s,"5",i-1);
                    res = Integer.parseInt(newString);
                    flag = true;
                    break;
                }
            }
        }

        if (flag){
            return res;
        }
        else {
            String newString = s+"5";
            return Integer.parseInt(newString);
        }
    }
}
