import java.io.*;
import java.util.*;

class Solution {
    static int[] numbers;
    static int target;
    static int size;
    static int answer;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        size = numbers.length;
        this.target = target;
        
        dfs(0, 0);
        return answer;
    }
    
    static void dfs(int index, int now) {
        if (index == size) {
            if (now == target) {
                answer++;
            }
            return;
        }
        
        dfs(index + 1, now + numbers[index]);
        dfs(index + 1, now - numbers[index]);
    }
}