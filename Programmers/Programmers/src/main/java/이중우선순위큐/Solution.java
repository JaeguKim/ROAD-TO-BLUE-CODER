package 이중우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minQ = new PriorityQueue<>();
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        for (String op : operations) {
            String ary[] = op.split(" ");
            String operator = ary[0];
            int num = Integer.parseInt(ary[1]);
            if (operator.equals("I")) {
                minQ.add(num);
                maxQ.add(num);
            }
            else {
                if (maxQ.size() == 0) continue;
                if (num == 1) {
                    int temp = maxQ.poll();
                    minQ = new PriorityQueue<>();
                    for (Integer e : maxQ.stream().collect(Collectors.toList())) {
                        minQ.add(e);
                    }
                }
                else {
                    int temp = minQ.poll();
                    maxQ = new PriorityQueue<>(Collections.reverseOrder());
                    for (Integer e : minQ.stream().collect(Collectors.toList())) {
                        maxQ.add(e);
                    }
                }
            }
        }
        if (minQ.size() == 0) {
            return new int[]{0,0};
        }
        else {
            return new int[]{maxQ.poll(),minQ.poll()};
        }
    }
}
