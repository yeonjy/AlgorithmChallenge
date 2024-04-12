import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Point {
        int x;
        int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final String SUCCESS = "happy";
    static final String FAIL = "sad";

    static boolean flag;
    static Point[] conveniences;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {  //test case만큼 반복
            flag = false;
            int convenienceCnt = Integer.parseInt(br.readLine());
            conveniences = new Point[convenienceCnt];
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int j = 0; j < convenienceCnt; j++) {
                st = new StringTokenizer(br.readLine());
                conveniences[j] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            Point dest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            bfs(start, dest);

            if (flag) {
                sb.append(SUCCESS).append("\n");
            } else {
                sb.append(FAIL).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void bfs(Point start, Point dest) {
        boolean[] isVisited = new boolean[conveniences.length];
        Queue<Point> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (Math.abs(p.x - dest.x) + Math.abs(p.y - dest.y) <= 1000) {
                flag = true;
                return;
            }

            for (int i = 0; i < conveniences.length; i++) {
                Point convenience = conveniences[i];
                if (!isVisited[i] && Math.abs(convenience.x - p.x) + Math.abs(convenience.y - p.y) <= 1000) {
                    q.add(convenience);
                    isVisited[i] = true;
                }
            }
        }
    }
}
