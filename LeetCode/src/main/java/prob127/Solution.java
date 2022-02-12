package prob127;

import java.util.*;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        que.add(beginWord);
        visited.add(beginWord);
        int ans = 1;
        while (!que.isEmpty() && !visited.contains(endWord)) {
            boolean isAdded = false;
            int size = que.size();
            for (int i=0; i<size; ++i) {
                String front = que.poll();
                for (int j = 0; j < front.length(); ++j) {
                    char[] tmpArr = front.toCharArray();
                    for (int k = 'a'; k <= 'z'; k++) {
                        tmpArr[j] = (char)k;
                        String tmpStr = String.valueOf(tmpArr);
                        if (!visited.contains(tmpStr) && wordSet.contains(tmpStr)) {
                            que.add(tmpStr);
                            visited.add(tmpStr);
                            isAdded = true;
                        }
                    }
                }
            }
            if (isAdded) ans++;
        }

        if (visited.contains(endWord)) return ans;
        return 0;
    }
}
