import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] tmp = s.split(" ");
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (String n : tmp) list.add(Integer.parseInt(n));

        System.out.println(amount(list));

    }

    static double amount(ArrayList<Integer> list) {

        int max = Collections.max(list);
        list.remove(Integer.valueOf(max));
        double total = max;
        for (int n : list) {
            total += (double)n / 2;
        }
        return total;

    }
}