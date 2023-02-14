package baekJoon.silver;

import java.util.Scanner;

public class B11659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int num = sc.nextInt();
        int arr[] = new int[len + 1];  //0으로 자동 초기화

        //index가 1인 요소부터 값 채움 -> 배열의 인덱스가 -1을 했을 때, 음수가 되는 것 방지
        for (int i = 1; i <= len; i++) arr[i] += sc.nextInt() + arr[i-1];
        for(int i = 0; i < num; i++) System.out.println(-arr[sc.nextInt() - 1] + arr[sc.nextInt()]);
    }
}
