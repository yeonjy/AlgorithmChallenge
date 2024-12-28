class Solution {
    public String solution(int n) {

        return dp(n);
    }

    static String dp(int now) {
        if (now <= 3) {
            if (now == 3) {
                return "4";
            } else {
                return String.valueOf(now);
            }
        }

        int value = now / 3;
        int left = now % 3;

        if (left == 0) {
            value--;
        }

        if (left == 0) {
            left = 4;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp(value)).append(left);
        return sb.toString();
    }
}