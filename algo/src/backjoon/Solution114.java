package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16918
//16918 봄버맨
public class Solution114 {

    static int R,C,N;
    static Point map[][];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static class Point{
        char v;
        int cnt;

        public Point(char v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }

    static void makeBoom() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].v == '.') {
                    map[i][j] = new Point('O', 3);
                }
            }
        }
    }

    static void boom(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].cnt == 0 && map[i][j].v == 'O') {

                    map[i][j] = new Point('.',-1);

                    for(int k=0; k<4; k++){
                        int x = i+dx[k];
                        int y = j+dy[k];
                        if(x<0 || y <0 || x>=R|| y>=C){
                            continue;
                        }
                        if(map[x][y].cnt != 0){ //'O'는 비교하면 안됨 -> O도 터트려야되기에
                            map[x][y] = new Point('.',-1);
                        }

                    }
                }
            }
        }
    }

    static void clear(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].v == 'O') {
                    map[i][j].cnt--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new Point[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            char tempList[] = temp.toCharArray();
            for(int j=0; j<C; j++){
                if(tempList[j] == 'O'){
                    map[i][j] = new Point(tempList[j],3);
                }else{
                    map[i][j] = new Point(tempList[j],-1);
                }
            }
        }

        for(int i = 0; i<N; i++){
            clear();
            if(i%2 ==1){
                makeBoom();
            }
            if(i%2==0){
                boom();
            }
        }

        show();

    }

    static void show(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++) {
                System.out.print(map[i][j].v);
            }
            System.out.println();
        }
    }
}
