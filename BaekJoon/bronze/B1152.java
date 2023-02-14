package baekJoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1152 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        if (tmp.equals("") || tmp.equals(" ")) System.out.println(0);
        else {
            String[] words = tmp.split(" ");
            int res = words.length;
            if (words[0].equals("")) System.out.println(res - 1);
            else System.out.println(words.length);
        }
    }
}
