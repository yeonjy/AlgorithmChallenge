package baekJoon.bronze;

import java.util.Scanner;

public class B1032 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] arr = new String[num];
        String res = "";
        for (int i = 0; i < num; i++) arr[i] = sc.next();  //문자열 입력

        for (int i = 0; i < arr[0].length(); i++) {
            for (int j = 0; j < num; j++) {
                if (arr[j].charAt(i)!=arr[0].charAt(i)) {
                    res += '?';
                    break;
                }
                if (j == num - 1) res += arr[0].charAt(i);
            }
        }
        System.out.println(res);
    }
}
