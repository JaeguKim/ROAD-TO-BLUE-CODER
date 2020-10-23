package Task3;

import java.util.HashSet;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    public int getDistinctNum(String time){
        HashSet<Character> set = new HashSet<>();
        String[] ary = time.split(":");
        for (String item : ary){
            for (int i=0; i<item.length(); i++){
                set.add(item.charAt(i));
            }
        }
        return set.size();
    }

    public String getDigitalTime(int hour, int min, int sec) {
        String hourStr = convertToTwoDigit(hour);
        String minStr = convertToTwoDigit(min);
        String secStr = convertToTwoDigit(sec);
        return String.format("%s:%s:%s", hourStr, minStr, secStr);
    }

    public String convertToTwoDigit(int num) {
        if (num < 10) {
            return String.format("0%d", num);
        } else
            return Integer.toString(num);
    }

    // ':' 나누고 오른쪽 부터 1초 증가, 60이되면 0으로 세팅
    // 분을 1증가, 60이 되면 0으로 세팅
    // 시간 1증가, 24가 되면 0으로 세팅
    // 두자리로 표현할때 앞쪽을 패딩 0으로 두게끔

    public String getAfterOneSec(String s) {
        String[] input = s.split(":");
        int hour = Integer.parseInt(input[0]);
        int min = Integer.parseInt(input[1]);
        int sec = Integer.parseInt(input[2]);
        sec += 1;
        if (sec < 60) {
            return getDigitalTime(hour, min, sec);
        }
        sec = 0;
        min += 1;
        if (min < 60) {
            return getDigitalTime(hour, min, sec);
        }
        min = 0;
        hour += 1;
        if (hour < 24) {
            return getDigitalTime(hour, min, sec);
        }
        hour = 0;
        return getDigitalTime(hour, min, sec);
    }

    // 완전탐색 풀이
    // 시작점부터 끝점까지 시간을 다 표현해서 distinct한 수를 계산한다.
    // 1초뒤에 있는 숫자를 리턴하는 함수를 구현한다
    // 끝 시간과 동일해질때 까지 반복하면서, distinct 한 숫자가 2개 이하면 카운팅을 한다
    public int solution(String S, String T) {
        String curTime = S;
        int ans = 0;
        while (true){
            if (getDistinctNum(curTime) <= 2){
                ans += 1;
            }
            if (curTime.equals(T)) 
                break;
            curTime = getAfterOneSec(curTime);
        }
        return ans;
    }
}
