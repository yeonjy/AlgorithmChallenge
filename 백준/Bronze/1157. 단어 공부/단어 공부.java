import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String upperStr = str.toUpperCase();
        String[] upperStrs = upperStr.split("");
        Map<String, Integer> alphaMap = new HashMap<>();

        for (String s : upperStrs) {
            if (alphaMap.containsKey(s)) {
                alphaMap.put(s, alphaMap.get(s) + 1);
            } else {
                alphaMap.put(s, 1);
            }
        }

        int max = alphaMap.values().stream().max((o1, o2) -> o1 - o2).get();
        String result = "";
        for (String key : alphaMap.keySet()) {
            if (max == alphaMap.get(key)) {
                if (result.isEmpty()) {
                    result = key;
                } else {
                    result = "?";
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
