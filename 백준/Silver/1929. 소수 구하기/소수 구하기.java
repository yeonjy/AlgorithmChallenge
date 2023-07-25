import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {  //소수 구하기
    public static void main(String[] args) throws IOException {

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        //소수 판별
        for(int i = 0; i <= b-a; i++) {
            if(prime(a + i)) System.out.println(a + i);
        }
    }

    public static boolean prime(int a) {
        if (a == 1) return false;
        else if (a == 2) return true;
        for (int i = 2; i <= Math.sqrt(a); i++)
            if (a % i == 0) return false;
        return true;
    }
}
