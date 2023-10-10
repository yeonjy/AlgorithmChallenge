import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final String RED = "R";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] colorCnt = new int[2];
        String line = br.readLine();

        String pre = "";
        for (String color : line.split("")) {
            if (!color.equals(pre)) {  //이전 색과 다르면
                if (color.equals(RED)) {
                    colorCnt[1]++;
                } else {
                    colorCnt[0]++;
                }
                pre = color;
            }
        }

        if (colorCnt[0] > colorCnt[1]) {
            System.out.println(colorCnt[1] + 1);
        } else {
            System.out.println(colorCnt[0] + 1);
        }
    }
}
