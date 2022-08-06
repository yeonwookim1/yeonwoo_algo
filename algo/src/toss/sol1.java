package toss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sol1 {


    public int solution(String s) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        int cnt = 1;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)) {
                cnt++;
            }else if(s.charAt(i) != s.charAt(i-1)){
                cnt = 1;
            }
            if(cnt==3){
                String temp = String.valueOf(s.charAt(i-2)) + String.valueOf(s.charAt(i-1)) + String.valueOf(s.charAt(i));
                list.add(temp);
            }
        }
        if(list.size()==0){
            answer = -1;
        }else {
            Collections.sort(list);
            answer = Integer.parseInt(list.get(list.size() - 1));
        }
        return answer;
    }





    public static void main(String[] args) {
        sol1 sol = new sol1();


        String s ="111999333";
        sol.solution(s);



    }
}
