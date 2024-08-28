import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String strN = String.valueOf(N);
        int result = 0;

        for (int i = 1; i < strN.length(); i++) {
            result += i * 9 * Math.pow(10L, Double.valueOf(i - 1));
        }
        result += strN.length() * (N - Math.pow(10L, Double.valueOf(strN.length() - 1)) + 1);


        System.out.println(result);
    }
}
