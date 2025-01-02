import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int goal = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        queue.add(64);

        int total = 64;

        while (total > goal) {
            int min = queue.poll();
            int dis = min / 2;
            if (total - min + dis >= goal) {
                queue.add(dis);
                total = total - dis;
            } else {
                queue.add(dis);
                queue.add(dis);
            }
        }
        System.out.println(queue.size());
    }
}
