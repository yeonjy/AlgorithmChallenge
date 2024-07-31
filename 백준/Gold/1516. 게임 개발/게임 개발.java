import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N + 1];  // 각 노드당 소요되는 시간
        int[] indegree = new int[N + 1];  // 선행되어야 하는 노드 수
        ArrayList<Integer> list[] = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1) {
                    break;
                }
                indegree[i]++;
                list[pre].add(i); // pre를 선행 노드로 갖는 노드를 list[pre]에 저장
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {  // 선행될 노드가 없으면 큐에 넣고 time 업데이트
            if (indegree[i] == 0) {
                q.offer(i);
                result[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int idx = q.poll();  // 큐에서 빼기
            for (int i : list[idx]) {
                result[i] = Math.max(result[i], result[idx] + time[i]);
                if (--indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }
}
