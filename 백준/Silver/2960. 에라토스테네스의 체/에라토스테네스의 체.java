import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int cnt = 0;

        boolean[] check= new boolean[N+1];

        for(int i=2; i<=N; i++){
            for(int j = i; j <= N; j += i) {
                if(!check[j]) {
                    cnt++;
                    check[j] = true;
                    if(cnt == K) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}