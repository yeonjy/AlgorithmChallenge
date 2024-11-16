import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static final int[] dy = new int[] {-1, 1, 0, 0};
	static final int[] dx = new int[] {0, 0, -1, 1};
	
	static int[][] map;
	static int success;
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			// map 초기화
			int[] start = new int[2];
			success = 0;
			map = new int[16][16];
			isVisited = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = line.charAt(j) - '0';
					if (map[i][j] == 2) {
						start = new int[] {i, j};
					}
				}
			}
			dfs(start[0], start[1]);
			sb.append("#" + tc + " " + success + "\n");
		}
		System.out.println(sb);
		
	}
	
	static void dfs(int y, int x) {
		isVisited[y][x] = true;
		if (map[y][x] == 3) {
			success = 1;
			return;
		}
		if (success == 1) {
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isValid(nx, ny) && !isVisited[ny][nx] && map[ny][nx] != 1) {
				dfs(ny, nx);
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < 16 && y < 16;
	}
}
