import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final String[] operator = new String[]{"+", "-", "x", "%"};
    static int N;
    static int[] nums;
    static String[] operators;
    static boolean[] isVisited;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        isVisited = new boolean[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        operators = new String[N - 1];
        st = new StringTokenizer(br.readLine());
        int flag = 0;
        //연산자 문자로 저장
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                operators[flag++] = operator[i];
            }
        }

        backtracking(nums[0], 0);
        System.out.println(max + "\n" + min);
    }

    static void backtracking(int value, int index) {
        //연산자를 사용하면 수 감소 & 리턴되면 다시 복구시키기
        if (index == N - 1) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
            return;
        }

        //모든 연산자 대입
        for (int i = 0; i < N - 1; i++) {
            if (!isVisited[i]) {  //해당 인덱스의 연산자를 사용하지 않았으면
                isVisited[i] = true;
                backtracking(calculate(value, operators[i], index + 1), index +1);
                isVisited[i] = false;
            }
        }
    }

    static int calculate(int value, String op, int index) {
        if (op.equals("+")) {
            return value + nums[index];
        }
        if (op.equals("-")) {
            return value - nums[index];
        }
        if (op.equals("x")) {
            return value * nums[index];
        }
        return value / nums[index];
    }
}
