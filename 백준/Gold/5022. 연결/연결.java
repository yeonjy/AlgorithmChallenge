import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Circuit {
        int index;

        public Circuit(int index) {
            this.index = index;
        }
    }

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static int N;
    static int M;
    static int[][] A;
    static int[][] B;
    static boolean[][] isVisited;
    static Circuit[][] map;
    static Map<Integer, int[]> locations;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        locations = new HashMap<>();
        map = new Circuit[N + 1][M + 1];
        A = new int[2][2];
        B = new int[2][2];

        int index = 1;

        //A 위치 저장
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        //B 위치 저장
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            B[i][0] = Integer.parseInt(st.nextToken());
            B[i][1] = Integer.parseInt(st.nextToken());
        }

        //locations & map 초기화
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                locations.put(index, new int[]{i, j});
                map[i][j] = new Circuit(index++);
            }
        }
    }

    static int connect(int[][] cable, int[][] other) {  //other[] :
        Queue<int[]> q = new LinkedList<>();
        int[] path = new int[(N + 1) * (M + 1) + 1];  //map 에 저장된 Circuit.index의 수 만큼의 크기
        int[] src = cable[0];  //케이블 시작점
        int[] dst = cable[1];  //케이블 끝점
        boolean isConnected = false;

        q.add(new int[]{src[0], src[1]});  //케이블 시작점 큐에 넣기
        path[map[src[0]][src[1]].index] = 0;  //path(경로)에 저장
        isVisited[src[0]][src[1]] = true;

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            if (x == dst[0] && y == dst[1]) {  //x, y가 도착지 위치면 종료
                isConnected = true;
                break;
            }

            for (int i = 0; i < 4; i++) {  //동서남북 탐색
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextX > N || nextY < 0 || nextY > M) {
                    continue;
                }
                if (nextX == other[0][0] && nextY == other[0][1]) {
                    continue;
                }
                if (nextX == other[1][0] && nextY == other[1][1]) {
                    continue;
                }
                if (!isVisited[nextX][nextY]) {
                    isVisited[nextX][nextY] = true;
                    path[map[nextX][nextY].index] = map[x][y].index;  //path update
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
        if (!isConnected) {
            return -1;  //연결되지 않았으면 다음 케이블도 연결 불가 -> 바로 return -1;
        }
        isVisited = new boolean[N + 1][M + 1];
        int index = map[dst[0]][dst[1]].index;
        int ret = 0;

        isVisited[dst[0]][dst[1]] = true;  //도착지는 방문으로 처리하여 지나가지 못하도록 함
        while (path[index] != 0) {
            int[] p = locations.get(path[index]);
            isVisited[p[0]][p[1]] = true;
            index = path[index];
            ret++;
        }
        return ret;
    }

    static void connection() {
        int case1 = 0;
        int case2 = 0;

        // A 연결 -> B 연결
        isVisited = new boolean[N + 1][M + 1];
        int distance = connect(A, B);

        if (distance == -1) {
            case1 = Integer.MAX_VALUE;
        } else {
            case1 += distance;
            distance = connect(B, A);

            if (distance == -1) {
                case1 = Integer.MAX_VALUE;
            } else {
                case1 += distance;
            }
        }

        //B 연결 -> A 연결
        isVisited = new boolean[N + 1][M + 1];
        distance = connect(B, A);

        if (distance == -1) {
            case2 = Integer.MAX_VALUE;
        } else {
            case2 += distance;
            distance = connect(A, B);
            if (distance == -1) {
                case2 = Integer.MAX_VALUE;
            } else {
                case2 += distance;
            }

            System.out.println(case1 == Integer.MAX_VALUE && case2 == Integer.MAX_VALUE ? "IMPOSSIBLE" : Math.min(case1, case2));
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        connection();
    }

}
