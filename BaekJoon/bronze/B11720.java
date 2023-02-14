package baekJoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11720 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());  //읽을 숫자 개수
        String line = br.readLine();  //숫자 한 줄로 입력받기
        int sum = 0;  //총합 저장 변수

        for (int i = 0; i < num; i++) sum += line.charAt(i) - '0';

        System.out.println(sum);
    }
}
