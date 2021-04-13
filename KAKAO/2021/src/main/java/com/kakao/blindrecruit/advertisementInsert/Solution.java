package com.kakao.blindrecruit.advertisementInsert;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class Time {
        int h;
        int m;
        int s;

        public Time(int h, int m, int s) {
            this.h = h;
            this.m = m;
            this.s = s;
        }

        public int getSec() {
            return 3600*h+60*m+s;
        }
    }

    public Time getTime(String s) {
        String[] arr = s.split(":");
        return new Time(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
    }

    public String convertToStr(int sec) {
        int h = sec/3600;
        int m = (sec%3600)/60;
        int s = sec%60;
        return String.format("%02d:%02d:%02d",h,m,s);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int[] cnt = new int[360000];
        for (String s : logs) {
            String[] arr = s.split("-");
            Time start = getTime(arr[0]);
            Time end = getTime(arr[1]);
            for (int i=start.getSec();i<end.getSec();i++) {
                cnt[i]++;
            }
        }
        int len = getTime(adv_time).getSec();
        int ans = 0;
        long sum = 0;
        long maxSum = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<len;i++) {
            q.add(cnt[i]);
            sum += cnt[i];
        }
        maxSum = sum;
        for (int i=len; i<=getTime(play_time).getSec(); i++) {
            sum -= q.poll();
            sum += cnt[i];
            q.add(cnt[i]);
            if (sum > maxSum) {
                ans = i-len+1;
                maxSum = sum;
            }
        }
        return convertToStr(ans);
    }
}
