import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int num = sc.nextInt();
        int arr[] = new int[len + 1];

        for (int i = 1; i <= len; i++) arr[i] += sc.nextInt() + arr[i-1];
        for(int i = 0; i < num; i++) System.out.println(-arr[sc.nextInt() - 1] + arr[sc.nextInt()]);
    }
}
