import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        IntStream.range(0, n).forEach(i -> arr[i] = Integer.parseInt(st.nextToken()));
        Arrays.sort(arr);

        int p1 = 0;
        int p2 = n - 1;
        int[] result = new int[2];
        long sum = Long.MAX_VALUE;

        while (p1 < p2) {
            long tmpSum = arr[p1] + arr[p2];
            if (Math.abs(tmpSum) < sum) {
                sum = Math.abs(tmpSum);
                result[0] = p1;
                result[1] = p2;
            }
            if (tmpSum < 0) {
                p1++;
            } else {
                p2--;
            }
        }
        System.out.println(arr[result[0]] + " " + arr[result[1]]);
    }
}
