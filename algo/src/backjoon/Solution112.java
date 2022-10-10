package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2174
//2174 로봇 시뮬레이션
public class Solution112 {
    static int map[][];
    static final int dx[] = {-1,0,1,0};
    static final int dy[] = {0,1,0,-1};
    static class Robot{
        int x,y;
        int d;
        public Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static class Order{
        int idx;
        String order;
        int cnt;

        public Order(int idx, String order, int cnt) {
            this.idx = idx;
            this.order = order;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        map = new int[B+1][A+1];
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        Map<Integer,Robot> robotMap = new HashMap<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            String d = st.nextToken();


            int dir = 0;
            if(d.equals("N")){
                dir = 0;
            }else if(d.equals("E")){
                dir = 1;
            }else if(d.equals("S")){
                dir = 2;
            }else if(d.equals("W")){
                dir = 3;
            }

            robotMap.put(i+1,new Robot(B-x+1,y,dir));
            map[B-x+1][y] = i+1;
        }

        List<Order> orderList = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int robotIdx = Integer.parseInt(st.nextToken());
            String execStr = st.nextToken();
            int execCnt = Integer.parseInt(st.nextToken());
            orderList.add(new Order(robotIdx, execStr, execCnt));
        }

        boolean isStop = false;

        for(int i=0; i<orderList.size(); i++){
            int idx = orderList.get(i).idx;
            String execStr = orderList.get(i).order;
            int cnt = orderList.get(i).cnt;

            Robot rt = robotMap.get(idx);

            for(int j=0; j<cnt; j++){
                int x = rt.x;
                int y = rt.y;
                int dir = rt.d;

//                show(B,A);
                if(execStr.equals("F")){
                    int xx = x + dx[dir];
                    int yy = y + dy[dir];

                    if(xx<=0 || xx >B || yy<=0 || yy>A){
                        System.out.println("Robot " + idx +" crashes into the wall");
                        isStop = true;
                        break;
                    }

                    if(map[xx][yy] != 0){
                        System.out.println("Robot "+idx+" crashes into robot "+map[xx][yy]);
                        isStop = true;
                        break;
                    }

                    rt.x = xx;
                    rt.y = yy;
                    map[xx][yy] = idx;
                    map[x][y] = 0;
                } else if(execStr.equals("L")){
                    rt.d = dir -1;
                    if(rt.d <0){
                        rt.d = 3;
                    }
                } else if(execStr.equals("R")){
                    rt.d = dir +1;
                    if(rt.d >3){
                        rt.d = 0;
                    }
                }

            }

            if(isStop){
                break;
            }
        }

        if(!isStop){
            System.out.println("OK");
        }


    }
    static void show(int A, int B){
        for(int i=1; i<=A; i++){
            for(int j=1; j<=B; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
