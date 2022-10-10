package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/20056
//마법사 상어와 파이어볼 20056
public class Solution111 {

    static int N,M,K;
    static Point map[][];
    static int dx[] = {-1,-1,0,1,1,1,0,-1};
    static int dy[] = {0,1,1,1,0,-1,-1,-1};
    static List<Ball> ballList;

    static class Ball{
        int x,y,m,s,d;

        public Ball(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static class Point{
        int d;
        int m,s;
        int cnt;
        boolean isOdd;
        boolean isEven;

        public Point() {
            this.d = -1;
            this.m = 0;
            this.s = 0;
            this.cnt = 0;
            this.isOdd = false;
            this.isEven = false;
        }
    }

    static void init(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] = new Point();
            }
        }
    }

    static void move(){
//        List<Ball> tempList = new ArrayList<>();
        for(Ball b : ballList){
            int x = b.x;
            int y = b.y;
            int m = b.m;
            int s = b.s;
            int d = b.d;

//            System.out.println("d = " + d);
            int xx = x;
            int yy = y;
            for(int i=0; i<s; i++){
                xx += dx[d];
                yy += dy[d];
                if(xx <= 0){
                    xx = N;
                }else if(xx > N){
                    xx = 1;
                }

                if(yy <= 0){
                    yy = N;
                }else if(yy > N){
                    yy = 1;
                }
            }

            map[xx][yy].m += m;
            map[xx][yy].s += s;
            if(map[xx][yy].d == -1){
                map[xx][yy].d = 0;
                map[xx][yy].d += d; //cnt >=2 인 경우에는 방향을 다시 정해주기 때문에 덮어쓰었다.
            }

            map[xx][yy].cnt ++;
            if(d%2 == 0){
                map[xx][yy].isEven = true;
            }else{
                map[xx][yy].isOdd = true;
            }

        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new Point[N+1][N+1];
        ballList = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r,c,m,s,d;
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            ballList.add(new Ball(r,c,m,s,d));
        }

        for(int i=0; i<K; i++){

            //move
            init();
            move();

            //show();
            while(!ballList.isEmpty()){
                ballList.remove(0);
            }

            divide();

        }

        int ans = 0;
        for(Ball b : ballList){
            ans += b.m;
        }


        System.out.println(ans);
    }

    static void divide(){

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (map[i][j].cnt == 0) {
                    continue;
                }
                if (map[i][j].cnt == 1) {
                    ballList.add(new Ball(i,j,map[i][j].m,map[i][j].s, map[i][j].d));
                }else{

                    int makeM = map[i][j].m/5;
                    if(makeM <=0){
                        continue;
                    }
                    int makeS = map[i][j].s / map[i][j].cnt;
                    if(map[i][j].isOdd && map[i][j].isEven){
                        ballList.add(new Ball(i,j,makeM,makeS, 1));
                        ballList.add(new Ball(i,j,makeM,makeS, 3));
                        ballList.add(new Ball(i,j,makeM,makeS, 5));
                        ballList.add(new Ball(i,j,makeM,makeS, 7));
                    }else{
                        ballList.add(new Ball(i,j,makeM,makeS, 0));
                        ballList.add(new Ball(i,j,makeM,makeS, 2));
                        ballList.add(new Ball(i,j,makeM,makeS, 4));
                        ballList.add(new Ball(i,j,makeM,makeS, 6));
                    }
                }
            }
        }
    }

    static void show(){
        for(int i=1; i<map.length; i++){
            for(int j=1; j<map[i].length; j++){
                System.out.print(map[i][j].cnt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
