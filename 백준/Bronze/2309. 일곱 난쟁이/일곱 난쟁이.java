import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] candidates = new int[9];
        for (int i = 0; i < 9; i++) {
            candidates[i] = Integer.parseInt(br.readLine());
        }
        int sum = Arrays.stream(candidates).sum();
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - candidates[i] - candidates[j] == 100) {
                    candidates[i] = 0;
                    candidates[j] = 0;
                    Arrays.sort(candidates);
                    StringBuilder sb = new StringBuilder();
                    for (int k = 2; k < 9; k++) {
                        sb.append(candidates[k]).append("\n");
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}
