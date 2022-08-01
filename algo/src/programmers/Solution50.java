package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/12973
//짝지어 제거하기
public class Solution50 {
    Stack<Character> stk;

    public boolean check(){
        boolean isCheck = false;
        List<Character> list = new ArrayList<>();
        while(!stk.isEmpty()){
            Character temp = stk.pop();

            if(stk.size()>=1) {
                if (temp == stk.peek()) {
                    stk.pop();
                    isCheck = true;
                }else {
                    if (list.size() > 0 && list.get(list.size() - 1) == temp) {
                        list.remove(list.size() - 1);
                    } else {
                        list.add(temp);
                    }
                }
            } else{
                if (list.size() > 0 && list.get(list.size() - 1) == temp) {
                    list.remove(list.size() - 1);
                } else {
                    list.add(temp);
                }
            }

        }

        for(int i=0; i<list.size(); i++){
             stk.add(list.get(i));
         }
        return isCheck;
    }

    public int solution(String s) {
        int answer = 0;
        stk = new Stack<>();

        for(int i=s.length()-1; i>0; i--){
            stk.push(s.charAt(i));
        }
        while(true){
            if(!check()){
                break;
            }
        }
        if(!stk.empty()){
            answer = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        new Solution50().solution("cdcd");
    }
}
