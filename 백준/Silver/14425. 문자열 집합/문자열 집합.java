import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<String> S = new ArrayList<>();
        List<String> testList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            testList.add(br.readLine());
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            if (S.contains(testList.get(i))) {
                result++;
            }
        }

        System.out.println(result);
    }
}
