import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> line = new ArrayList<>(N + 1);
        int[] input = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N; i >= 1; i--) {
            line.add(input[i], i);
        }
        StringBuilder sb = new StringBuilder();
        line.stream().forEach(i -> sb.append(i).append(" "));
        System.out.println(sb);
    }
}
