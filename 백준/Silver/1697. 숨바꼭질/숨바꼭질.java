import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] field = new int[100001];
    static boolean[] isVisited = new boolean[100001];
    static int k;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n != k) {
            bfs(n);
        }

        System.out.println(field[k]);
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = getNext(i, now);
                if (!flag && next <= 100000 && next >= 0 && !isVisited[next]) {
                    if (next == k) {
                        flag = true;
                    }
                    queue.add(next);
                    isVisited[next] = true;
                    field[next] = field[now] + 1;
                }
            }

        }

    }

    static int getNext(int flag, int now) {
        if (flag == 0) {
            return now + 1;
        }
        else if (flag == 1) {
            return now - 1;
        } else {
            return now * 2;
        }
    }


}
