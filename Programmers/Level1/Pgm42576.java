package pgm42576;
// 프로그래머스 -완주하지 못한 선수 (42576)
import java.util.Arrays;
public class Solution {
    public static String solution(String[] participant, String[] completion) {
    	int k;
    	int num = completion.length;

    	Arrays.sort(participant);
    	Arrays.sort(completion);
    	for (k = 0;;) {
    		if(!(participant[k].equals(completion[k])))
    			break;
    		if(num == ++k)
    			break;
    	}
    	return participant[k];
    }
}