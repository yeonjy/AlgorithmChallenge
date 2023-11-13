import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 1;
        int cnt = 1;
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) arr[i] = i;  //배열에 N까지의 자연수 저장

        int index1 = 1;
        int index2 = 1;
        for (int i = 1; index1 < n && index2 < n; i++) {
            if (sum < n) sum += ++index2;  //합이 N보다 작은 경우: 합을 늘려야됨 -> index2 증가 후 sum에 더하기
            else if (sum > n) sum -= index1++;  //합이 N보다 큰 경우: 합이 줄어야됨 -> index1 증가 후 sum에서 빼기
            else {
                cnt++;
                sum += ++index2;  //합이 N과 같은 경우: cnt++ 후, 배열의 끝까지 검사하기 위해 index2++
            }
        }
        
        System.out.println(cnt);
    }
}