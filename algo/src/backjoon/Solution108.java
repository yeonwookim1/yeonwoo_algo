package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/19237
//어른 상어
public class Solution108 {
    static int N;
    static int M;
    static int k;
    static int map[][][];   //[0] 상어 번호 [1] 냄새 [2] 냄새주인
    static int visit[][];
    static int dx[] = {0,-1,1,0,0};
    static int dy[] = {0,0,0,-1,1};
    static List<Shark> list;
    static class Shark{
        int num;
        int dir;
        int dirs[][];
        int x;
        int y;
        public Shark(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
            dirs = new int[5][5];
            dirs[1][0] = 1;
            dirs[2][0] = 2;
            dirs[3][0] = 3;
            dirs[4][0] = 4;

        }
        public void setDir(int dir){
            this.dir = dir;
        }
        public void setXY(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1][3];
        list = new ArrayList<>();

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp != 0){
                    list.add(new Shark(temp,i,j));
                    map[i][j][0] = temp;
                    map[i][j][1] = k;
                    map[i][j][2] = temp;
                }else{
                    map[i][j][0] = temp;
                    map[i][j][1] = 0;
                    map[i][j][2] = 0;
                }

            }
        }
        Collections.sort(list, new Comparator<>(){
            @Override
            public int compare(Shark s1, Shark s2){
                return s1.num - s2.num;
            }
        });

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<list.size(); i++){
            Shark tempShark = list.get(i);
            tempShark.setDir(Integer.parseInt(st.nextToken()));
            list.set(i,tempShark);
        }

        for(int i=0; i<list.size(); i++) {
            Shark tempShark = list.get(i);
            for(int idx=1; idx<=4; idx++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=1; j<=4; j++){
                    tempShark.dirs[idx][j] = Integer.parseInt(st.nextToken());
                }
            }
            list.set(i,tempShark);
        }

//        for(Shark s : list){
//            System.out.println("s.num = " + s.num);
//            System.out.println("s.dir = " + s.dir);
//
//            for(int i=0; i<5; i++){
//                for(int j=0; j<5; j++){
//                    System.out.print(s.dirs[i][j]+ " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        int cnt =0;
        while(cnt <= 1000){
            if(list.size() == 1){
                break;
            }

            //print();
            move();

            cnt++;

        }

        if(cnt > 1000){
            cnt = -1;
        }
        System.out.println(cnt);
    }
    static void delSmell(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j][1] > 0){
                    map[i][j][1]--;
                    if(map[i][j][1]==0){
                        map[i][j][2] = 0;
                    }
                }
            }
        }
    }
    static void print(){
        System.out.println();

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++) {
                System.out.print(map[i][j][0] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void move(){
        List<Shark> sharkList = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            Shark sk = list.get(i);

            int x = sk.x;
            int y= sk.y;
            int dir = sk.dir;

            boolean isFind = false;

            //빈공간 찾기
            for(int j=1; j<=4; j++){
                int xx = x + dx[sk.dirs[dir][j]];
                int yy = y + dy[sk.dirs[dir][j]];

                if (xx <= 0 || yy <= 0 || xx > N || yy > N) {
                    continue;
                }
                if(map[xx][yy][1] == 0){

                    //System.out.println(sk.num + "=====================" + xx +"   " + yy + "  " + map[xx][yy][0]+"을 만남");
                    if(map[xx][yy][0] != 0 && map[xx][yy][0] < sk.num){ //잡아 먹힘
                        //System.out.println("DIE");
                        isFind = true;
                        break;
                    }else{
                        Shark liveShark = new Shark(sk.num, xx, yy);
                        liveShark.setDir(sk.dirs[dir][j]);
                        liveShark.dirs = sk.dirs;
                        map[xx][yy][0] = sk.num;

                        sharkList.add(liveShark);

                        isFind = true;
                        break;
                    }
                }
            }
            if(isFind){
                continue;
            }

            //내 냄새 찾기
            for(int j=1; j<=4; j++) {
                int xx = x + dx[sk.dirs[dir][j]];
                int yy = y + dy[sk.dirs[dir][j]];

                if (xx <= 0 || yy <= 0 || xx > N || yy > N) {
                    continue;
                }

                //System.out.println("==================");
                //System.out.println(sk.num + " " + map[xx][yy][2]);
                //System.out.println("==================");

                if(map[xx][yy][2] == sk.num){
                    Shark liveShark = new Shark(sk.num, xx, yy);
                    liveShark.setDir(sk.dirs[dir][j]);
                    map[xx][yy][0] = sk.num;
                    liveShark.dirs = sk.dirs;
                    sharkList.add(liveShark);
                    isFind = true;
                    break;
                }
            }

            //System.out.println("isFind = " + isFind);
        }

        for(int i=0; i<list.size(); i++){

            map[list.get(i).x][list.get(i).y][0] = 0;
        }
        list.clear();

        delSmell();
        for (Shark ss : sharkList) {
            map[ss.x][ss.y][0] = ss.num;
            map[ss.x][ss.y][1] = k;
            map[ss.x][ss.y][2] = ss.num;
            list.add(ss);
        }

        
//        for(Shark s : list){
//            System.out.println("s.num = " + s.num);
//            System.out.println("s.x = " + s.x + "  s.y = " + s.y);
//            System.out.println("s.dir = " + s.dir);
//
//        }
//        System.out.println();
    }
}
