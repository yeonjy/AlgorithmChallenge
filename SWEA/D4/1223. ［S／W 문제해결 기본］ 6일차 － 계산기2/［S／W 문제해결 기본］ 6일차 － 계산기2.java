import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int result = 0;
            br.readLine();
            Stack<Integer> nums = new Stack<>();
            Stack<Character> op = new Stack<>();
            String line = br.readLine();

            for (char ch : line.toCharArray()) {
                if (ch == '+' || ch == '*') {
                    if (ch == '+' && !op.isEmpty()) {
                        nums.push(nums.pop() + nums.pop());
                    } else {
                        op.push(ch);
                    }
                } else {
                    int num = ch - '0';
                    if (!op.isEmpty() && op.peek() == '*') {
                        nums.push(nums.pop() * num);
                        op.pop();
                    } else {
                        nums.push(num);
                    }
                }
            }
            result = nums.pop();
            if (!op.isEmpty()) {
                result += nums.pop();
            }
            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.println(sb);
    }
}
