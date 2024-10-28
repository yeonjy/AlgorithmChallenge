import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            // 입력
            int dump = Integer.parseInt(br.readLine());
            List<Integer> boxes = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                boxes.add(Integer.parseInt(st.nextToken()));
            }
            // 풀이
            for (int i = 0; i < dump; i++) {
                int max = Collections.max(boxes);
                int min = Collections.min(boxes);
                boxes.set(boxes.indexOf(max), max - 1);
                boxes.set(boxes.indexOf(min), min + 1);
            }
            int res = Collections.max(boxes) - Collections.min(boxes);
            sb.append("#" + tc + " ").append(res).append("\n");
        }
        System.out.println(sb);
    }
}