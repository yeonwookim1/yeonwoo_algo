package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/23288
//주사위 굴리기2
public class Solution115 {

    static int map[][];
    static int N,M,K;
    static int dice[] = {2,1,5,6,4,3};
    static final int dx[] = {-1,0,1,0};
    static final int dy[] = {0,1,0,-1};

    static void upDice(){
        int temp[] = new int[6];
        temp[0] = dice[3];
        temp[1] = dice[0];
        temp[2] = dice[1];
        temp[3] = dice[2];
        temp[4] = dice[4];
        temp[5] = dice[5];
        change(temp);
    }
    static void downDice(){
        int temp[] = new int[6];
        temp[0] = dice[1];
        temp[1] = dice[2];
        temp[2] = dice[3];
        temp[3] = dice[0];
        temp[4] = dice[4];
        temp[5] = dice[5];
        change(temp);
    }
    static void leftDice(){
        int temp[] = new int[6];
        temp[0] = dice[0];
        temp[1] = dice[5];
        temp[2] = dice[2];
        temp[3] = dice[4];
        temp[4] = dice[1];
        temp[5] = dice[3];
        change(temp);
    }

    static void rightDice(){
        int temp[] = new int[6];
        temp[0] = dice[0];
        temp[1] = dice[4];
        temp[2] = dice[2];
        temp[3] = dice[5];
        temp[4] = dice[3];
        temp[5] = dice[1];
        change(temp);
    }

    static void change(int temp[]){
        for(int i=0; i<6; i++){
            dice[i] = temp[i];
        }
    }

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(int target, int x, int y){
        Queue<Point> q = new LinkedList<>();
        int visit[][] = new int[N+1][M+1];
        visit[x][y] = 1;
        q.add(new Point(x,y));
        int cnt = 1;

        while(!q.isEmpty()){
            int r = q.peek().x;
            int c = q.peek().y;
            q.poll();

            for(int i=0; i<4; i++){
                int xx = r + dx[i];
                int yy = c + dy[i];
                if(xx<=0 || yy<=0 || xx>N || yy>M){
                    continue;
                }
                if(visit[xx][yy]==0 && map[xx][yy]==target){
                    q.add(new Point(xx,yy));
                    visit[xx][yy] = 1;
                    cnt++;
                }
            }
        }

        return cnt * target;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];

        int nowX = 1;
        int nowY = 1;
        int dir = 1; // 북 0, 동 1, 남 2, 서 3

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        while(K>0){

            int x = nowX + dx[dir];
            int y = nowY + dy[dir];
            if(x<=0){
                dir = 2;
                x +=2;
            }else if(x>N){
                dir = 0;
                x-=2;
            }
            if(y<=0){
                dir = 1;
                y+=2;
            }else if(y>M){
                dir = 3;
                y-=2;
            }
            nowX = x;
            nowY = y;

            if(dir==0){
                downDice(); //왜 down이랑 up이랑 반대지??
            }else if(dir==1){
                rightDice();
            }else if(dir==2){
                upDice();
            }else if(dir==3){
                leftDice();
            }

//            for(int a : dice){
//                System.out.print(a + " ");
//            }
//            System.out.println("dice[3] : " + dice[3]);

            if(dice[3] > map[nowX][nowY]){
//                rightRotate();
                dir +=1;
                if(dir>=4){
                    dir = 0;
                }
            }else if(dice[3] < map[nowX][nowY]){
//                leftRotate();
                dir -=1;
                if(dir<0){
                    dir = 3;
                }
            }

            ans += bfs(map[nowX][nowY],nowX, nowY);


//            System.out.println(nowX + " " + nowY + " " + dir);
//            show();
            K--;
        }

        System.out.println(ans);

    }

    static void show(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
