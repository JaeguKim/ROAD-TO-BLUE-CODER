import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

// 더이상 진행 못하는 경우
// 모든 토큰 값이 P보다 크고, score 0일때
// score가 0일때 가장 작은 값을 face up, score += 1
// score > 1일때 가장 큰값을 face down, score -= 1, power += token[i] -> 최대 가질수있는 수, 작은수 부터 계산
// or 
// 가장 작은 값을 face up, score += 1, power -= token[i], 
//O(n^2) 풀이
class Solution {

    public int getGain(Deque<Integer> deq, int power) {
        Iterator<Integer> iter = deq.iterator();
        int gain = 0;
        int sum = 0;
        while (iter.hasNext()) {
            sum += iter.next();
            if (power >= sum)
                gain += 1;
            else
                break;
        }
        return gain;
    }

    public int updateDeque(Deque<Integer> deq, int power) {
        Iterator<Integer> iter = deq.iterator();
        int cnt = 0;
        //deq.
        System.out.println("1 Power : "+power);
        while (iter.hasNext()) {
            int nextVal = iter.next();
            if (power >= nextVal) {
                power -= nextVal;
                cnt += 1;
            } else
                break;
        }
        System.out.println("2 Power : "+power);
        iter = deq.iterator();
        while (cnt-- > 0){
            deq.pollFirst();
        }
        return power;
    }

    public int bagOfTokensScore(int[] tokens, int P) {
        int power = P;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int token : tokens) {
            deque.add(token);
        }
        int score = 0;
        while (true) {
            int case1 = getGain(deque, power);
            if (case1 == deque.size()) {
                score += case1;
                break;
            }
            int last = deque.poll();
            int case2 = -1;
            if (score >= 1)
                case2 = getGain(deque, power + last) - 1;
            System.out.printf("1 %d %d %d %d\n", case1, case2, score, power);
            if (case1 <= 0 && case2 <= 0)
                break;
            else if (case1 > case2) {
                score += case1;
                deque.add(last);
                power = updateDeque(deque, power);
            } else if (case1 <= case2) {
                score -= 1;
                power += last;
            }
            System.out.printf("2 %d %d %d %d\n", case1, case2, score, power);
        }
        return score;
    }
}
