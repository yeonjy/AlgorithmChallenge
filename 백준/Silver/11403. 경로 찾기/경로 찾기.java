import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[num][num];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < num; k++) {
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        for (int[] line : map) {
            for(int n : line) {
                bw.write(n + " ");
            }
            bw.newLine();
        }
        bw.flush();

        bw.close();
        br.close();
    }
}
