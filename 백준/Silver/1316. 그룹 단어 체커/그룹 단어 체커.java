import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = num;

        for (int i = 0; i < num; i++) {
            String[] words = br.readLine().split("");

            List<String> list = new ArrayList<>();
            for (String word : words) {
                if (list.contains(word)) {
                    if (list.get(list.size() - 1).equals(word)) continue;
                    else {
                        result--;
                        break;
                    }
                }
                else list.add(word);
            }
        }
        System.out.println(result);
    }
}
