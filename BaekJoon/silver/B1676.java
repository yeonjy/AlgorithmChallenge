package baekJoon.silver;

import java.util.Scanner;

public class B1676 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int cnt = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 5 == 0) cnt++;  //10인 경우
            if (i % 25 == 0) cnt++;  //100인 경우
            if (i % 125 == 0) cnt++;  //1000인 경우
        }

        System.out.println(cnt);

    }
}
