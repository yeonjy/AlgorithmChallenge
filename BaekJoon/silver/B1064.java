package baekJoon.silver;

import java.util.Scanner;

public class B1064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num1 = new int[2];
        int[] num2 = new int[2];
        int[] num3 = new int[2];
        num1[0] = sc.nextInt();
        num1[1] = sc.nextInt();
        num2[0] = sc.nextInt();
        num2[1] = sc.nextInt();
        num3[0] = sc.nextInt();
        num3[1] = sc.nextInt();

        double a = Math.hypot(num2[0] - num3[0], num2[1] - num3[1]);
        double b = Math.hypot(num3[0] - num1[0], num3[1] - num1[1]);
        double c = Math.hypot(num1[0] - num2[0], num1[1] - num2[1]);

        double ans;

        if ((num2[0] - num1[0]) * (num3[1] - num1[1]) == (num2[1] - num1[1]) * (num3[0] - num1[0])) {
            ans = -1;
        } else {
            double ab = 2*a+2*b;
            double bc = 2*b+2*c;
            double ca = 2*c+2*a;
            ans = Math.max(Math.max(ab, bc), ca) - Math.min(Math.min(ab, bc), ca);
        }
        System.out.println(ans);
    }
}
