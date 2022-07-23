package pgm64061;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int s = board.length, i = -1, score = 0;
        int[] newBoard = new int[s*s];
        int[][] changedBoard = new int[s][s];
        
        for (int t = 0; t < s; t++) {
            for (int j = 0; j < s; j++) {
                changedBoard[j][t] = board[t][j];
            }
        }
        
        for (int k : moves) {
            i++;
            int tmp[] = Solution.sol(changedBoard[k-1]);
            newBoard[i] = tmp[0];
            changedBoard[k-1][tmp[1]] = 0;
           
            if (i>0 && newBoard[i] == newBoard[i-1]) {
                newBoard[i] = 0; 
                newBoard[i-1] = 0;
                i -= 2;
                if (i < 0) i+=1;
                score += 2;
            }
            if (newBoard[i] == 0)
                i--;                
        }
        return score;
    }
    // 제일 위에 있는 숫자 반환하는 함수
    public static int[] sol(int[] line) {
        for (int i=0; i < line.length; i++) {
            if (line[i]!=0) {     
                return new int[] {line[i], i};
            }
        }
        return new int[] {0, 0};
    }
}