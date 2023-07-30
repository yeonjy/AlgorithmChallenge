import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static ArrayList<Integer>[] arr;
    static boolean[] isVisited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }
        dfs(K);
        isVisited = new boolean[N + 1];
        sb.append("\n");
        bfs(K);
        System.out.println(sb);
    }
    static void dfs(int index) {
        isVisited[index] = true;
        sb.append(index + " ");
        for (int i : arr[index]) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int index) {
        isVisited[index] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        while (!queue.isEmpty()) {
            int a = queue.poll();
            sb.append(a + " ");
            for (int i : arr[a]) {
                if (!isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}
