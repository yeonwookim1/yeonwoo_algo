import java.util.HashMap;

//https://programmers.co.kr/learn/courses/30/lessons/42576
//완주하지 못한 선수

public class Solution5 {
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();

        System.out.println();
        for(String str : completion){
            int cnt = 1;
            if(map.get(str) != null){
                map.put(str, map.get(str)+cnt);
            } else{
                map.put(str, cnt);
            }
        }
        
        // map.forEach((key,value)->{
        //     System.out.println(key + " : " +value);
        // });

        for(String str : participant){
            if(map.get(str) == null){
                answer = str;
                break;
            } else{
                int temp = map.get(str)-1;
                System.out.println("temp : " + temp);
                if(temp >= 0){
                    map.put(str, temp);
                } else{
                    answer = str;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] s_array = {"leo", "leo", "leo"};
        String[] b_array = {"leo", "leo"};
        new Solution5().solution(s_array, b_array);
    }
}
