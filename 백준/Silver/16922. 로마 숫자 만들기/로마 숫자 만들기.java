import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static final int[] nums = new int[]{1, 5, 10, 50};
    static int N;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        backtracking(0, 0, 0);

        System.out.println(set.size());

    }

    static void backtracking(int len, int sum, int now) {
        if (len >= N) {
            set.add(sum);
            return;
        }

        for (int i = now; i < 4; i++) {
            backtracking(len + 1, sum + nums[i], i);
        }
    }
}
