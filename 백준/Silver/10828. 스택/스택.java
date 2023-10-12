import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static final String PUSH = "push";
    static final String POP = "pop";
    static final String SIZE = "size";
    static final String EMPTY = "empty";
    static final String TOP = "top";
    static final String NOTHING = "-1";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals(PUSH)) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (s.equals(POP)) {
                if (stack.isEmpty()) {
                    sb.append(NOTHING);
                } else {
                    sb.append(stack.pop());
                }
                sb.append("\n");
            } else if (s.equals(SIZE)) {
                sb.append(stack.size()).append("\n");
            } else if (s.equals(EMPTY)) {
                if (stack.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else if (s.equals(TOP)) {
                if (stack.isEmpty()) {
                    sb.append(NOTHING);
                } else {
                    sb.append(stack.peek());
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }
}
