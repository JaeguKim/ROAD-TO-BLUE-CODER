package Asteroid

import java.util.Stack;

// 양수가 나오면 집어넣는다
// 음수가 나오면 비어있으면 넣고 
// 비어있지 않으면 직전에 있는 원소를 빼내서 로직처리를한다
// 안에있는 원소가 비어있거나 크기가 큰수가 발견 없어질때 까지 반복한다
// 상태를 리턴한다
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int num : asteroids) {
            if (num > 0) {
                stack.push(num);
                continue;
            }
            while (true) {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(num);
                    break;
                }
                if (stack.peek() < Math.abs(num)) {
                    stack.pop();
                    continue;
                } 
                else if (stack.peek() == Math.abs(num)) {
                    stack.pop();
                    break;
                }
                else break;
            }
        }
        int[] res = new int[stack.size()];
        for (int i=stack.size()-1; i>-1; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}