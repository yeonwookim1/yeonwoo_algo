package kakaobank;

public class Sol1 {
    int color;
    int pos;
    int x,y;
    static final int piano[][] = {{2,4,6,0,9,11,0},
                                    {1,3,5,7,8,10,12}};

    public int solution(int[] music) {
        int answer = 0;
        color = 0;
        pos = 1;
        x = 1;
        y = 0;

        for (int idx = 0; idx < music.length; idx++) {
            int move = 0;
            if (color == 1) { //위치 검은색
                if(pos > music[idx]){
                    x +=1;
                }else if(pos < music[idx]){
                    x +=1;
                    y +=1;
                }else{
                    continue;
                }
                pos = piano[x][y];
                color = 0;
                move++;
            }

            //if (color == 0) { //위치 하얀색
                //밞을께 검은색
                if(music[idx] == 2 || music[idx] == 4||music[idx] == 6
                || music[idx] == 9 || music[idx] == 11){
                    color = 1;
                    if(pos >= music[idx]+1){
                        move += leftMove(music[idx]+1);
                        x -=1;
                        y-=1;
                        move++;
                        pos = piano[x][y];
                    }else if(pos<=music[idx]-1){
                        move += rightMove(music[idx]-1);
                        x-=1;
                        move++;
                        pos = piano[x][y];
                    }
                }else{//밞을께 흰색
                    color = 0;
                    if(pos < music[idx]){    //->
                        move += rightMove(music[idx]);
                    }else if(pos > music[idx]){  //<-
                        move += leftMove(music[idx]);
                    }
                    pos = music[idx];
                }
            //}

//            System.out.println("x = " + x);
//            System.out.println("y = " + y);
//            System.out.println("pos = " + pos);
//            System.out.println("color = " + color);
//            System.out.println("move = " + move);
//            System.out.println();

            answer += move;

        }

        System.out.println("answer = " + answer);
        return answer;
    }

    public int leftMove(int target){
        int move = 0;
        for(int i=piano[1].length-1; i>=0; i--) {
            if(pos<piano[1][i]){
                continue;
            }
            if(target==piano[1][i]){
                break;
            }
            move++;
            y--;
        }
        return move;
    }
    public int rightMove(int target){
        int move = 0;
        for(int i=0; i<piano[1].length; i++){
            if(pos>piano[1][i]){
                continue;
            }
            if(target==piano[1][i]){
                break;
            }
            move++;
            y++;
        }
        return move;
    }

    public static void main(String[] args) {
        int music[] = {10,9,4,5,12};
        Sol1 sol1 = new Sol1();
//        sol1.solution(music);

        int m1[] = {6,4,2,11};
        sol1.solution(m1);
    }
}
