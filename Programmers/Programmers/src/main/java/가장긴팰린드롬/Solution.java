package 가장긴팰린드롬;

public class Solution {

    public int solution(String s) {
        char[] arr = s.toCharArray();
        for (int i=s.length();i>1;i--) {
            for (int j=0;j<=s.length()-i;j++) {
                boolean isSame = true;
                int last = j+i-1;
                for (int z=j;z<j+i/2;z++) {
                    int opposite = last-z+j;
                    if (arr[z] != arr[opposite]) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) return i;
            }
        }
        return 1;
    }
}
