
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  //원생 수
        Long K = Long.parseLong(st.nextToken());  //조의 수

        List<Long> heights = new ArrayList<>();
        List<Long> diff = new ArrayList<>(N);
        for (String s : br.readLine().split(" ")) {
            Long parseLong = Long.parseLong(s);
            heights.add(parseLong);
        }
        for(int i = 1; i < N; i++) {
            diff.add(heights.get(i) - heights.get(i-1));
        }
        Collections.sort(diff, Collections.reverseOrder());
        for(int i = 0; i < K-1; i++) {
            diff.set(i, 0L);
        }
        System.out.println(diff.stream().mapToLong(Long::longValue).sum());

    }
}
