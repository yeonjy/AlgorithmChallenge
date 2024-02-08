import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] building;
    static int F, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        building = new int[F + 1];

        bfs(S);
        System.out.println(building[G] != 0 ? building[G] - 1 : "use the stairs");
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        building[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == G) {
                break;
            }

            int up = now + U;
            int down = now - D;

            if (up <= F && building[up] == 0) {
                building[up] = building[now] + 1;
                queue.add(up);
            }

            if (down >= 1 && building[down] == 0) {
                building[down] = building[now] + 1;
                queue.add(down);
            }
        }
    }
}
