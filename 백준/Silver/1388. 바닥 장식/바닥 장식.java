import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] tiles = new char[N][M];
        for(int i = 0; i < N; i++) {
            tiles[i] = br.readLine().toCharArray();
        }
        rowDfs(tiles);
        columnDfs(tiles);
        System.out.println(cnt);

    }

    private static void columnDfs(char[][] tiles) {
        for(int i = 0; i < M; i++) {
            char check = '-';
            for (int j = 0; j < N; j++) {
                if(tiles[j][i] == '|' && check != tiles[j][i]) {
                    cnt++;
                }
                check = tiles[j][i];
            }
        }
    }

    static void rowDfs(char[][] tiles) {
        for(char[] line : tiles) {
            char check = '|';
            for(char tile : line) {
                if(tile == '-' && tile != check) {
                    cnt++;
                }
                check = tile;
            }
        }
    }
}