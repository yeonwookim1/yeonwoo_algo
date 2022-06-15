import java.util.ArrayList;
import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/42587
//프린터
public class Solution6 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : priorities){
            list.add(a);
        }
        while(!list.isEmpty()){
            int temp = list.remove(0);
            boolean isAdd = false;
            for(int i=0; i<list.size(); i++){
                if(temp < list.get(i)){
                    list.add(temp);
                    isAdd = true;
                    break;
                }
            }
            if(!isAdd){
                answer++;
                if(location >0){
                    location--;
                }else if(location ==0){
                    break;
                }else{
                    location = list.size()-1;
                }
            } else{
                location--;
                if(location<0){
                    location = list.size()-1;
                }
            }
            
            
        }
        
        return answer;
    }

    public static void main(String[] args) {
        
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        new Solution6().solution(priorities,location);
     
        
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(4);
        System.out.println(st.firstElement());
        System.out.println(st.get(1));
        st.pop();
        System.out.println(st.get(0));
    }
}
