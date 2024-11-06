import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int[] dx = new int[]{0, -1, 1, 0, 0};  // X, 상, 하, 좌, 우
    static final int[] dy = new int[]{0, 0, 0, -1, 1};  // X, 상, 하, 좌, 우
    static final int[] reverse = new int[]{0, 2, 1, 4, 3};  // 반대 방향

    static int N;
    static Node[][] map;

    static class Node {
        int num;
        int direc;

        public Node(int num, int direc) {
            this.num = num;
            this.direc = direc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // map 초기화
            map = new Node[N][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int direc = Integer.parseInt(st.nextToken());
                map[x][y] = new Node(num, direc);
            }

            // M시간 만큼 돌기
            for (int time = 0; time < M; time++) {
                move();
            }

            // 미생물 총합 구하기
            int sum = getSum();
            sb.append("#" + tc + " " + sum + "\n");
        }
        System.out.println(sb);
    }

    static int getSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != null) {
                    sum += map[i][j].num;
                }
            }
        }
        return sum;
    }

    static void move() {
        Node[][] nextMap = new Node[N][N];
        int[][] numMap = new int[N][N];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[x][y] != null) {
                    Node now = map[x][y];
                    int nX = x + dx[now.direc];
                    int nY = y + dy[now.direc];

                    // 옮긴 위치가 가장자리일 경우
                    if (nX == 0 || nY == 0 || nX == N - 1 || nY == N - 1) {
                        now.num /= 2;
                        now.direc = reverse[now.direc];
                    }

                    // 옮긴 위치에 이미 다른 미생물이 모인 경우
                    if (nextMap[nX][nY] != null) {
                        // 지금 군집의 미생물 수가 더 많은 경우
                        if (nextMap[nX][nY].num < now.num) {
                            nextMap[nX][nY].num = now.num;
                            nextMap[nX][nY].direc = now.direc;
                        }
                    } else {
                        nextMap[nX][nY] = new Node(now.num, now.direc);
                    }
                    numMap[nX][nY] += now.num;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nextMap[i][j] != null) {
                    nextMap[i][j].num = numMap[i][j];
                }
            }
        }
        map = nextMap.clone();
    }
}
