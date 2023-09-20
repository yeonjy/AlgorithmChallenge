import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Conference[] conferences;
        int cnt = 0;
        long now = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        int num = Integer.parseInt(br.readLine());
        conferences = new Conference[num];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            conferences[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //회의 종료 순서대로 정렬
        List<Conference> sortedConf = Arrays.stream(conferences)
                .sorted(Comparator.comparing(c -> c.start))
                .sorted(Comparator.comparing(c -> c.finish)).collect(Collectors.toList());

        //그리디 알고리즘
        for (int i = 0; i < num; i++) {
            if (now <= sortedConf.get(i).start) {
                cnt++;
                now = sortedConf.get(i).finish;
            }
        }

        System.out.println(cnt);
    }

    static class Conference {
        int start;
        int finish;

        public Conference(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}