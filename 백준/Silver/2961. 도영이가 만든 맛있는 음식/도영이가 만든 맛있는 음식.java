import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class FoodIngredient {
        int S = 0;
        int B = 0;

        public FoodIngredient(int s, int b) {
            S = s;
            B = b;
        }
    }

    static int min = Integer.MAX_VALUE;
    static int ingredientNum;
    static List<FoodIngredient> ingredientList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ingredientNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < ingredientNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredientList.add(new FoodIngredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int ingredientCnt = 0;
        int sMul = 1;
        int bPlus = 0;
        int idx = 0;

        setMinResult(ingredientCnt, idx, sMul, bPlus);

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void setMinResult(int ingredientCnt, int idx, int sMul, int bPlus) {
        if (idx == ingredientNum) {
            if(ingredientCnt != 0) {
                min = Math.min(min, Math.abs(sMul - bPlus));
            }
            return;
        }
        setMinResult(ingredientCnt, idx + 1, sMul, bPlus); // 재료 넣지 않은 것
        setMinResult(ingredientCnt + 1, idx + 1, sMul * ingredientList.get(idx).S, bPlus + ingredientList.get(idx).B); // 재료를 넣은 것
    }
}
