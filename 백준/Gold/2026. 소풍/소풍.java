import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    static int N;
    static int F;

    static List<Integer> group;
    static List<Integer>[] friends;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        // 변수 초기화
        friends = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            friends[i] = new ArrayList<>();
        }
        isVisited = new boolean[N][N];

        for (int i = 0; i < F; i++) {  // 학생 정보 입력
            st = new StringTokenizer(br.readLine());
            int student1 = Integer.parseInt(st.nextToken());
            int student2 = Integer.parseInt(st.nextToken());
            friends[student1].add(student2);
            friends[student2].add(student1);
        }

        for (int i = 1; i <= N; i++) {
            friends[i].sort((o1, o2) -> o1 - o2);
        }

        for (int i = 1; i <= N; i++) {
            if (friends[i].size() >= K - 1) {  //친구가 K명 이상이면 탐색
                group = new ArrayList<>();
                isVisited = new boolean[N + 1][N + 1];
                backtracking(i, 1);
                if (group.size() >= K) {
                    group.sort((o1, o2) -> o1 - o2);
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < K; j++) {
                        sb.append(group.get(j)).append("\n");
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    static void backtracking(int friend, int depth) {
        for (int i : group) {
            if (!friends[friend].contains(i)) {
                return;
            }
            isVisited[friend][i] = true;
        }
        group.add(friend);
        for (int i : friends[friend]) {
            if (!isVisited[friend][i]) {
                backtracking(i, depth + 1);
            }
        }
    }
}
