class Solution {
    public int solution(int n, int[] tops) {
        int[] a = new int[n + 1];  // 그냥 정삼각형
        int[] b = new int[n + 1];  // 역 정삼각형
        a[1] = 1;
        if (tops[0] == 1) {
            b[1] = 3;
        } else {
            b[1] = 2;
        }
        
        for (int i = 2; i <= n; i++) {
            a[i] = (a[i - 1] + b[i - 1]) % 10_007;
            if (tops[i - 1] == 1) {
                b[i] = (a[i - 1] * 2 + b[i - 1] * 3) % 10_007;
            } else {
                b[i] = (a[i - 1] + b[i - 1] * 2) % 10_007;
            }
        }
        
        return (a[n] + b[n]) % 10_007;
    }
}