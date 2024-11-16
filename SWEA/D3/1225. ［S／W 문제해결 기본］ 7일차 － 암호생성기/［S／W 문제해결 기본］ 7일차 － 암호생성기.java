import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] arr;
    static int[] newArr;
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[9];
            newArr = new int[9];
            flag = true;
            for (int i = 1; i <= 8; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            while (flag) {
                cicle();
            }

            // 출력 String 만들기
            sb.append("#" + tc + " ");
            for (int i = 1; i <= 8; i++) {
                sb.append(newArr[i] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void cicle() {
        newArr = arr.clone();
        for (int i = 1; i <= 5; i++) {
            move(arr[i] - i);
            if (newArr[8] <= 0) {
                newArr[8] = 0;
                flag = false;
                return;
            }
        }
        arr = newArr.clone();
    }

    static void move(int num) {
        for (int i = 1; i < 8; i++) {
            newArr[i] = newArr[i + 1];
        }
        newArr[8] = num;
    }
}
