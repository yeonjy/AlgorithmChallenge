import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[6];
        int MaxWidthI=0,MaxWidth=0,MaxHeight=0,MaxHeightI=0,d;
        for(int i=0;i<6;i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            arr[i]=Integer.parseInt(st.nextToken());

            if((d==1 || d==2)&& MaxWidth<arr[i]) {
                MaxWidth=arr[i];
                MaxWidthI=i;
            }

            else if((d==3 || d==4)&& MaxHeight<arr[i]){
                MaxHeight=arr[i];
                MaxHeightI=i;
            }
        }

        int right;
        int left;
        int minWidth;
        int minHeight;

        if(MaxWidthI+1==6)right=0;
        else right=MaxWidthI+1;

        if(MaxWidthI-1==-1)left=5;
        else left=MaxWidthI-1;

        minHeight=Math.abs(arr[right]-arr[left]);

        if(MaxHeightI+1==6)right=0;
        else right=MaxHeightI+1;

        if(MaxHeightI-1==-1)left=5;
        else left=MaxHeightI-1;

        minWidth=Math.abs(arr[right]-arr[left]);

        System.out.println(((MaxWidth*MaxHeight)-(minHeight*minWidth)) * N);
    }
}