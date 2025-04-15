import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int m;
    static int []arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n];

        int right = Integer.MIN_VALUE;
        String[] s1 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(s1[i]);
            right = Math.max(arr[i],right);
        }

        int left= 0;

        while(left<right){
            int mid = (left+right)/2;
            if(solve(mid)<=m){
                right=mid;
            }else{
                left=mid+1;
            }
        }

        System.out.println(right);
    }

    private static int solve(int mid){
        int count = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if(max - min > mid) {
                count++;
                max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
                i--;
            }
        }
        return count;
    }
}