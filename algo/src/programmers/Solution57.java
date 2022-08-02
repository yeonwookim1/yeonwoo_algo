package programmers;

import java.util.ArrayList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/76502
//괄호 회전하기
public class Solution57 {

    int len;
    String ori;
//    public String revers(int idx){
//        StringBuffer sb = new StringBuffer();
//        for(int i=idx; i<len; i++){
//            sb.append(ori.charAt(i));
//        }
//        for(int i=0; i<idx; i++){
//            sb.append(ori.charAt(i));
//        }
//        return sb.toString();
//    }

    public String revers(String s){
        String temp = s.substring(1);
        return temp + String.valueOf(s.charAt(0));
    }
    public boolean check(String s){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<len; i++) {
            int temp = s.charAt(i) - '0';
            if(list.size()!=0){
                if(temp - list.get(list.size()-1) == 1){
                    list.remove(list.size()-1);
                }else{
                    list.add(temp);
                }
            }else{
                list.add(temp);
            }
        }
        if(list.size()==0){
            return true;
        }
        return false;
    }

    public int solution(String s) {
        int answer = 0;
        s = s.replace('[','1').replace(']','2')
                .replace('(','3').replace(')','4')
                .replace('{','5').replace('}','6');
        ori = s;
        len = s.length();
        for(int i=0; i<len; i++){
            if(i!=0){
                s = revers(s);
            }
            if(check(s)){
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {

        String s= "[)(]";
        Solution57 sol = new Solution57();
        sol.solution(s);
    }
}
