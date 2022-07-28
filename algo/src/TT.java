
public class TT {


    public int select(int who, int a, int b, int cnt){
        int next = 0;
        if(who == 0){
            next = 1;
        }
        if(a==0 || b==0){
            return cnt+1;
        }
        else if(a==b){
            return cnt+1;
        }
        else{
            if((b-a==1) && b>=2){
                b-=2;
            } else if(a>=2){
                b=1;
            } else{
                b -= (b-a-1);
            }
        }

        if(a<b){
            cnt = select(next, a, b, cnt+1);
        } else{
            cnt = select(next, b, a, cnt+1);
        }


        return cnt;
    }
    

    public int[] solution(int a, int b){
        int[] answer = new int[2];
        if(a==0 || b==0){
            answer[0] = 0;
            answer[1] = 1;
        }
        int result = 0;
        if(a<b){
            result = select(0,a,b,0);
        } else if(a>b){
            result = select(0,b,a,0);
        }
        answer[0] = (result+1)%2;
        answer[1] = result;

        return answer;
    }
    
}
