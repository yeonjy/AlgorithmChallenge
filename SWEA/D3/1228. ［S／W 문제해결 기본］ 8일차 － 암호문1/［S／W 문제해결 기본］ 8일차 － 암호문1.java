import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static List<Integer> nums = new ArrayList<>();
    static String[] orders;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            nums = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }
            // 명령어 입력
            int M = Integer.parseInt(br.readLine());
            String line = br.readLine();
            orders = line.split("I ");
            for (int i = 1; i <= M; i++) {
                move(orders[i]);
            }

            // 10개 출력
            sb.append("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
                sb.append(nums.get(i) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void move(String order) {
        String[] line = order.split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);

        for (int i = 0; i < y; i++) {
            nums.add(x + i, Integer.parseInt(line[2 + i]));
        }
    }
}
