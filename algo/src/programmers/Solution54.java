package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/70129
//이진변환 반복하기
public class Solution54 {
    public String change(int s){
        System.out.println(s);
        long a = (long) s;
        String num = "";
        while(a>0){
            Long temp = a%2;
            num = Long.toString(temp) + num;
            a = a/2;
        }
        return num;
    }
    public int[] solution(String s) {
        int[] answer = new int[2];
        boolean isSize = true;
        while(isSize){
//            StringBuffer sb = new StringBuffer();
//            System.out.println("s = " + s);
            int num = 0;
            for(int i=0; i<s.length(); i++){
                char temp = s.charAt(i);
                if(temp == '0'){
                    answer[1]++;
                }else{
                    num++;
                }
            }
            s = change(num);
            answer[0]++;
            if(s.equals("1")){
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution54 sol = new Solution54();
        String s = "110010101001";
        sol.solution(s);


        String num = "123";
        int answer = 0;
        int idx = 1;
        int a = Integer.parseInt(num);
        String b = Integer.toString(a);

        long c = Long.parseLong(num);
        String d = Long.toString(c);

    }
}
