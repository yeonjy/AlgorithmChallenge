import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] couples = {5, 3, 4, 1, 2, 0};
    static final  int[][] sides = {{1, 2, 3, 4},
            {0, 2, 4, 5},
            {0, 1, 3, 5},
            {0, 2, 4, 5},
            {0, 1, 3, 5},
            {1, 2, 3, 4}};
    static int N;
    static int[][] dices;
    static int result;
    static int max;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        dices = new int[N][6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (N == 0) {
            System.out.println(0);
            return;
        }

        // 첫번째 Dice
        for (int i = 0; i < 6; i++) {
            max = 0;
            getDice(i, 0);
            result = Math.max(result, max);
        }
        System.out.println(result);
    }

    static void getDice(int down, int idx) {
        int[] dice = dices[idx];
        int[] side = sides[down];
        max += Math.max(dice[side[0]], Math.max(dice[side[1]], Math.max(dice[side[2]], dice[side[3]])));

        if (idx >= N - 1) {
            return;
        }
        // (idx + 1)번 주사위의 아랫면 idx 찾기
        int num = dice[couples[down]];  //윗면 num
        for (int i = 0; i < 6; i++) {
            if (dices[idx + 1][i] == num) {
                getDice(i, idx + 1);
                return;
            }
        }
    }
}
