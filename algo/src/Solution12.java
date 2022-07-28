import java.util.HashMap;
import java.util.Map;

public class Solution12 {
    Map<String, Integer> map = new HashMap<>();
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] cnt = new int[n+1];
        cnt[1]++;
        map.put(words[0],1);
        for(int i=1; i<words.length; i++){
            String preStr = words[i-1].substring(words[i-1].length()-1);
            String nowStr = words[i].substring(0,1);
            
            cnt[i%n+1]++;
            
            if(!preStr.equals(nowStr)){
                answer[0] = i%n +1;
                answer[1] = cnt[i%n+1];
                break;
            } 
            if(map.containsKey(words[i])){
                answer[0] = i%n +1;
                answer[1] = cnt[i%n+1];
                break;
            }
            else{
                map.put(words[i],1);
            }

            for(int j=1; j<=n; j++){
                System.out.print(cnt[j] + " ");
            }
            System.out.println();

        }

        return answer;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        new Solution12().solution(2, words);
    }
}
