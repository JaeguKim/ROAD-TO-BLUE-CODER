package 베스트앨범;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    class Song {
        int num;
        int play;

        public Song(int num,int play) {
            this.num = num;
            this.play = play;
        }
    }
    Map<String, List<Song>> map;
    Map<String,Integer> playTimeMap;
    public int[] solution(String[] genres, int[] plays) {
        map = new HashMap<>();
        playTimeMap = new HashMap<>();
        for (int i=0;i<genres.length;i++) {
            if (!map.containsKey(genres[i])) map.put(genres[i],new ArrayList<>());
            map.get(genres[i]).add(new Song(i,plays[i]));
            playTimeMap.put(genres[i],playTimeMap.getOrDefault(genres[i],0)+plays[i]);
        }
        for (String genre : genres) {
            Collections.sort(map.get(genre), new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    return o2.play-o1.play;
                }
            });
        }
        List<Map.Entry<String,Integer>> sortedPlayTime = new LinkedList<Map.Entry<String, Integer>>(playTimeMap.entrySet());
        return sortedPlayTime.stream()
                .sorted((o1,o2)->o2.getValue()-o1.getValue())
                .map(e->e.getKey())
                .flatMap(k->map.get(k).stream().limit(2))
                .mapToInt(x->x.num).toArray();
    }
}
