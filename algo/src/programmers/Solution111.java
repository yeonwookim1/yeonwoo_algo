package programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/92335?language=java
//k진수에서 소수 개수 구하기

class Solution111 {
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n,k);

        num += "0";

        // 211020101011

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<num.length(); i++){
            char ch = num.charAt(i);

            if(ch == '0'){
                if(sb.length() !=0 && isPrime(sb.toString())){
                    // System.out.println(sb.toString());
                    answer++;
                    sb.setLength(0);
                }else{
                    sb.setLength(0);
                }
            }else{
                sb.append(ch);
            }
        }

//        if(sb.length() != 0){
//            char ch = num.charAt((num.length()-1) - sb.length());
//            if()
//        }

        return answer;
    }

    public boolean isPrime(String s){
        Long n = Long.parseLong(s,10);
        if(n==1){
            return false;
        }
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        System.out.println(Integer.toString(n,3));
        Solution111 app = new Solution111();
        app.solution(n,k);

        int n1 = 110011;
        int k1 = 10;
        app.solution(n1,k1);
    }
}
