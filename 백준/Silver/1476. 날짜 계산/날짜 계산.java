import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int earth = 1;
        int sun = 1;
        int moon = 1;
        Long current = 1L;

        Scanner sc = new Scanner(System.in);
        int earthResult = sc.nextInt();
        int sunResult = sc.nextInt();
        int moonResult = sc.nextInt();

        while (earth != earthResult || sun != sunResult || moon != moonResult) {
            current++;
            if (earth == 15) {
                earth = 1;
            } else {
                earth++;
            }
            if (sun == 28) {
                sun = 1;
            } else {
                sun++;
            }
            if (moon == 19) {
                moon = 1;
            } else {
                moon++;
            }
        }

        System.out.println(current);

    }
}
