
//https://school.programmers.co.kr/learn/courses/30/lessons/17682
//[1차]다트게임
public class Solution25 {

    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            int score[] = new int[5];
            int idx = 0;

            int num=0;

            for(int i=0; i<dartResult.length(); i++){
                Character ch = dartResult.charAt(i);

                if(Character.isDigit(ch)){
                    int temp = Integer.parseInt(ch.toString());
                    if(Character.isDigit(dartResult.charAt(i+1))){
                        num += temp*10;
                    } else{
                        if(num != 0){
                            num += temp;
                        }else{
                            num = temp;
                        }
                        idx++;
                    }

                }
                else if(ch == '#'){
                    score[idx] *= -1;
                }else if(ch =='*'){
                    if(idx==1){
                        if(ch=='*'){
                            score[idx] *= 2;
                        }
                    } else if(idx>1){
                        if(ch=='*'){
                            score[idx] *= 2;
                            score[idx-1] *= 2;
                        }
                    }
                }else{
                    int powCnt = 1;
                    if(ch=='D'){
                        powCnt = 2;
                    } else if(ch=='T'){
                        powCnt = 3;
                    }else{
                        powCnt = 1;
                    }
                    score[idx] += Math.pow(num, powCnt);
                    num = 0;
                }
            }


            for(int a : score){
                answer += a;
            }
            return answer;
        }
    }
}
