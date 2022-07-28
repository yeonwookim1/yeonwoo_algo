import java.util.ArrayList;
import java.util.Arrays;

public class Solution4 {

    public int[] solution(int[] answers) {
        ArrayList<Integer> ans = new ArrayList<>();

        int[] pp1 = {1,2,3,4,5};
        int[] pp2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pp3 = {3,3,1,1,2,2,4,4,5,5};

        int[] socre = {0,0,0};
        for(int i=0; i<answers.length; i++){
            if(pp1[i%5] == answers[i]){
                socre[0]++;
            }
            if(pp2[i%8] == answers[i]){
                socre[1]++;
            }
            if(pp3[i%10] == answers[i]){
                socre[2]++;
            }
        }

        int[] arr = new int[socre.length];
        for(int i = 0; i < socre.length; i++){
            arr[i] = socre[i];
        }
        Arrays.sort(arr);
        
        for(int i = 0; i < socre.length; i++){
            if(socre[i]==arr[2]){
                ans.add(i+1);
            }
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] temp = {1,2,3,4,5};
        Solution4 s4 = new Solution4();
        s4.solution(temp);
    }
    
}

