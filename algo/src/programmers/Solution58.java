package programmers;

import java.util.HashMap;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/77885
//2개 이하로 다른 비트
public class Solution58 {

    public String changeBit(long a){
        return Long.toBinaryString(a);
    }
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        Map<Long,String> map = new HashMap<>();

        int idx = 0;
        int len = answer.length;
        for(int i=0; i<len; i++){
            String str = changeBit(numbers[i]);

            if(numbers[i]%2==0){
                answer[i] = numbers[i] +1;
            }else{
                String binary = Long.toBinaryString(numbers[i]);

                if(binary.indexOf('0')<0){  //0이 없는경우
                    binary = "0" + binary;
                }
                //뒤에서 부터 0나오면 01 -> 10으로 변환

                int a = binary.lastIndexOf('0');
                StringBuilder sb = new StringBuilder(binary);
                sb.setCharAt(a,'1');
                sb.setCharAt(a+1,'0');
                answer[i] = Long.parseLong(sb.toString(),2);
            }

        }


        for(long a : answer){
            System.out.println("a" + a);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution58 sol = new Solution58();

        String s = "100101010110101";
        System.out.println("@@" + s.indexOf('0'));
        int num = 3;
        System.out.println(num+(num^(num+1)+1)/4);
        long numbers[] = {2,3,7,9,15};
        sol.solution(numbers);

    }

}
