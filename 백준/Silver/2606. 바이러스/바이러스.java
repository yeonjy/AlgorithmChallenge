import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final int START_NUM = 1;
    static boolean[] isVisited;
    static ArrayList<Integer>[] arr;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerNum = Integer.parseInt(br.readLine());
        int lineNum = Integer.parseInt(br.readLine());
        isVisited = new boolean[computerNum + 1];
        arr = new ArrayList[computerNum + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < lineNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        dfs(START_NUM);
        System.out.println(res - 1);  //1 제외
    }
    static void dfs(int index) {
        isVisited[index] = true;
        res++;
        for (int i : arr[index]) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }
    }
}
