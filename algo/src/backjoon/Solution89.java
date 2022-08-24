package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2933
//미네랄
public class Solution89 {

    static int R,C;
    static char arr[][];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int visit[][];
    static List<Point> downList;

    static void print(){
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Point{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R+1][C+1];
        visit = new int[R+1][C+1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 1; j <= C; j++) {
                arr[i][j] = temp.charAt(j - 1);
            }
        }

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int wood[] = new int[N];
        for(int i=0; i<N; i++){
            wood[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            int r = R - wood[i] +1;
            boolean isBreak = false;
            int breakY =0;
            if(i%2==0){
                for(int j=1; j<=C; j++){
                    if(arr[r][j] == 'x'){
                        arr[r][j] = '.';
                        isBreak = true;
                        breakY = j;
                        break;
                    }
                }
            }else{
                for(int j=C; j>0; j--){
                    if(arr[r][j] == 'x'){
                        arr[r][j] = '.';
                        isBreak = true;
                        breakY = j;
                        break;
                    }
                }
            }

           // print();
            //check
            if(isBreak){
                int x = r;
                int y = breakY;
                List<Point> list = new ArrayList<>();
                for(int k=0; k<4; k++){
                    int xx = x +dx[k];
                    int yy = y +dy[k];
                    if(xx<=0 || yy<=0 || xx>R || yy>C){
                        continue;
                    }
                    if(arr[xx][yy] == 'x') {
                        list.add(new Point(xx, yy));
                    }
                }
                initVisit();
                downList = new ArrayList<>();
                for(int k=0; k<list.size(); k++){
                    while(downList.size()>0){
                        downList.remove(0);
                    }
                    downList.add(new Point(list.get(k).x, list.get(k).y));
//                    System.out.println("downList.get(0).x = " + downList.get(0).x);
//                    System.out.println("downList.get(0).y = " + downList.get(0).y);

                    boolean isDown = check(list.get(k).x, list.get(k).y);   //1층이 있으면 true
                    //System.out.println(isDown);
                    if(!isDown){
                        while(true){
                            if(down()){
                                break;
                            }
                           // print();
                        }
                        break;
                    }
                }
            }
        }

        print();
    }

    static boolean down() {
        char copyArr[][] = new char[R+1][C+1];
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                copyArr[i][j] = arr[i][j];
            }
        }
        boolean isStop = false;
        List<Point> list = new ArrayList<>();
//        System.out.println("downList.size() = " + downList.size());
        for (int i = 0; i < downList.size(); i++) {
            int x = downList.get(i).x;
            int y = downList.get(i).y;
            copyArr[x][y] = '.';
        }
        for (int i = 0; i < downList.size(); i++) {
            int x = downList.get(i).x;
            int y = downList.get(i).y;
            if(x+1 >R || copyArr[x+1][y] == 'x'){
                isStop = true;
                break;
            }
            list.add(new Point(x+1,y));
        }
        if(isStop){
            return true;
        }
        for(int i=0; i<downList.size(); i++){
            arr[downList.get(i).x][downList.get(i).y] = '.';
        }
        for(int i=0; i<list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;
            arr[x][y] = 'x';
        }

        for(int i=0; i<list.size(); i++) {
            downList.remove(0);
            downList.add(list.get(i));
        }



        return false;
    }

    static boolean check(int x, int y){
        if(visit[x][y] == 1){
            return true;
        }
        boolean isOne = false;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visit[x][y] = 1;

        while(!q.isEmpty()){
            int tx = q.peek().x;
            int ty = q.peek().y;
            q.poll();
            if(tx==R){
                isOne = true;
            }
            for(int k=0; k<4; k++) {
                int xx = tx + dx[k];
                int yy = ty + dy[k];
                if (xx <= 0 || yy <= 0 || xx > R || yy > C) {
                    continue;
                }
                if(arr[xx][yy] == 'x' && visit[xx][yy] ==0){
                    q.add(new Point(xx,yy));
                    downList.add(new Point(xx,yy));
                    visit[xx][yy] = 1;
                }
            }

        }


        return isOne;
    }

    static void initVisit(){
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                visit[i][j] = 0;
            }
        }


    }
}
