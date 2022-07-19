package pgm12903;
// 프로그래머스 - 가운데 글자 가져오기 (12903)
class Solution {
    public String solution(String s) {
        int l = s.length();
        return l % 2 == 0 ? s.substring(l/2-1,l/2 + 1) : s.substring(l/2, l/2+1);
    }
}
