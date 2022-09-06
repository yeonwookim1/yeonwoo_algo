package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/status?user_id=kop4845&problem_id=2573&from_mine=1
//빙산
public class Solution103 {

    static int dx[]= {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int N,M;
    static class Point{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int check(int arr[][]){
        int visit[][] = new int[N][M];
        int cnt =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visit[i][j]==0 && arr[i][j] !=0){
                    cnt++;
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i,j));
                    visit[i][j] = 1;
                    while(!q.isEmpty()){
                        int x = q.peek().x;
                        int y =q.peek().y;
                        q.poll();
                        for (int k = 0; k < 4; k++) {
                            int xx = x + dx[k];
                            int yy = y + dy[k];
                            if (xx < 0 || xx >= N || yy < 0 || yy >= M) {
                                continue;
                            }
                            if(visit[xx][yy]==0 && arr[xx][yy]!=0){
                                q.add(new Point(xx,yy));
                                visit[xx][yy]=1;
                            }

                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while(true) {
            int temp = check(arr);
//            System.out.println("temp = " + temp);
            if(temp>1){
                break;
            }else if(temp==0){
                cnt = 0;
                break;
            }
            int copyMap[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0) {
                        for (int k = 0; k < 4; k++) {
                            int xx = i + dx[k];
                            int yy = j + dy[k];
                            if (xx < 0 || xx >= N || yy < 0 || yy >= M) {
                                continue;
                            }
                            if (arr[xx][yy] == 0) {
                                copyMap[i][j]--;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] += copyMap[i][j];
                    if(arr[i][j] <0){
                        arr[i][j]=0;
                    }
                }
            }

            cnt++;

//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
        }

        System.out.println(cnt);
    }
}
