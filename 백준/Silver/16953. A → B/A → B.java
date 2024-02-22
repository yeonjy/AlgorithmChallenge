import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int start;
    static int end;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        end = sc.nextInt();
        int result = bfs();

        System.out.println(result);
    }

    static int bfs() {
        int now = end;
        int cnt = 1;

        while (now != start) {
            if (now < start) {
                return -1;
            }
            if (now % 10 == 1) {
                cnt++;
                now = (now - 1) / 10;
            } else if (now % 2 == 0){
                cnt++;
                now /= 2;
            } else {
                return -1;
            }
        }
        return cnt;
    }
}
