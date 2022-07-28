public class HDD3 {
    public int[] solution(int a, int b){
        int[] answer = new int[2];
        if(a==0 || b==0 || a==b){
            answer[0] = 0;
            answer[1] = 1;
        }else{
            //seq 1 :  A
            //seq -1 : B
            int seq = 1;
            int cnt = 0;
            while(true){
                if(a==1 || b==1 || a==b){
                    if(seq==1){
                        answer[0] = 0;
                    } else{
                        answer[1] = 1;
                    }
                    answer[1] = cnt+2;
                    break;
                }
                if(Math.abs(a-b)==1){
                    if(seq==1){
                        answer[0] = 1;
                    } else{
                        answer[0] = 0;
                    }
                    answer[1] = cnt+3;
                    break;
                }

                if(a>b){
                    while(Math.abs(a-b) == 1){
                        a -= 1;
                    }
                }else if(a<b){
                    while(Math.abs(a-b) == 1){
                        b -= 1;
                    }
                }

                cnt++;
                seq *= -1;
            }
        }


        for(int t : answer){
            System.out.println(t);
        }
        return answer;
    }

    public static void main(String[] args) {
        new HDD3().solution(1, 2);
    }

}
