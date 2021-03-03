package com.kakao.blindrecruit.ranksearch;


import java.util.*;

class Info {
    private String lang;
    private String job;
    private String career;
    private String food;
    private int score;

    public Info(String lang,String job, String career, String food, int score) {
        this.lang = lang;
        this.job = job;
        this.career = career;
        this.food = food;
        this.score = score;
    }

    public String getLang() { return lang;}
    public String getJob() {return job;}
    public String getCareer() {return career;}
    public String getFood() {return food;}
    public int getScore() {return score;}

}

class Solution {
    public Map<String, List<Integer>> makeMap(List<Info> info) {
        String[] langs = new String[]{"cpp","java","python","-"};
        String[] jobs = new String[]{"backend","frontend","-"};
        String[] careers = new String[]{"junior","senior","-"};
        String[] foods = new String[]{"chicken","pizza","-"};
        Map<String,List<Integer>> map = new HashMap<>();
        for (String lang : langs) {
            for (String job : jobs) {
                for (String career : careers) {
                    for (String food : foods) {
                        map.put(lang+job+career+food,new ArrayList<>());
                    }
                }
            }
        }
        for (Info e : info) {
            for (int l = 0; l < 2; l++){
                for (int j = 0; j < 2; j++){
                    for (int c = 0; c < 2; c++){
                        for (int f = 0; f < 2; f++){
                            String lang = l == 0 ? "-" : e.getLang();
                            String job = j == 0 ? "-" : e.getJob();
                            String career = c == 0 ? "-" : e.getCareer();
                            String food = f == 0 ? "-" : e.getFood();
                            map.get(lang+job+career+food).add(e.getScore());
                        }
                    }
                }
            }
        }
        return map;
    }

    public List<Info> getInfo(String[] info) {
        List<Info> list = new ArrayList<>();
        for (String s : info) {
            String[] temp = s.split(" ");
            list.add(new Info(temp[0],temp[1],temp[2],temp[3],Integer.parseInt(temp[4])));
        }
        return list;
    }

    public int getAns(Map<String,List<Integer>> map, String query) {
        String[] split = query.split(" ");
        String key = split[0] + split[2] + split[4] + split[6];
        int score = Integer.parseInt(split[7]);
        List<Integer> list = map.get(key);
        int left = 0;
        int right = list.size()-1;
        int lowerbnd = -1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (list.get(mid) < score) {
                left = mid+1;
            }
            else {
                lowerbnd = mid;
                right = mid-1;
            }
        }
        if (lowerbnd < 0) return 0;
        return list.size() - lowerbnd;
    }

    public int[] solution(String[] info, String[] query) {
        List<Info> list = getInfo(info);
        list.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.getScore() - o2.getScore();
            }
        });
        Map<String,List<Integer>> map = makeMap(list);
        int[] ans = new int[query.length];
        int i = 0;
        for (String q : query) {
            ans[i++] = getAns(map,q);
        }
        return ans;
    }
}