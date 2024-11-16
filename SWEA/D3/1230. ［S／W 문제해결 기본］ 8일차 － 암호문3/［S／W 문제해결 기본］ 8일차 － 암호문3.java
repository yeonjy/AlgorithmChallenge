import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static List<Integer> nums = new ArrayList<>();
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                String order = st.nextToken();
                if (order.equals("I")) {
                    insert();
                } else if (order.equals("D")) {
                    delete();
                } else {
                    add();
                }
            }

            sb.append("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
                sb.append(nums.get(i) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void insert() {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        for (int i = 0; i < y; i++) {
            nums.add(x + i, Integer.parseInt(st.nextToken()));
        }
    }

    static void delete() {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int i = 0; i < y; i++) {
            nums.remove(x);
        }
    }

    static void add() {
        int y = Integer.parseInt(st.nextToken());
        for (int i = 0; i < y; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
    }
}
