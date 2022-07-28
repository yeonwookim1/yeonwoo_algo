import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution21 {
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int visit[][];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int N;
    static int M;
    static int ans;

    public int[][] bfs(int[][] arr, int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visit[x][y] =1;

        while(!q.isEmpty()){
            int now_x = q.peek().x;
            int now_y = q.peek().y;
            q.poll();

            for(int i=0; i<4; i++){
                int xx = now_x + dx[i];
                int yy = now_y + dy[i];
                if(xx <0 || yy<0 || xx>=N || yy >=M){
                    continue;
                }
                if(arr[xx][yy] == 0 && visit[xx][yy] == 0){
                    visit[xx][yy] = 1;
                    arr[xx][yy] = 2;
                    q.add(new Point(xx,yy));
                }
            }
        }
        return arr;
    }

    public void visitInit(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                visit[i][j] = 0;
            }
        }
    }

    public void check(int[][] arr){

        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0){
                    cnt++;
                }
            }
        }
        if(ans < cnt){
            ans = cnt;
        }
    }
    public void virus(int[][] arr){


        visitInit();
        int[][] copyMap = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                copyMap[i][j] = arr[i][j];
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 2 && visit[i][j] ==0){
                    arr = bfs(arr, i, j);
                }
            }
        }
        check(arr);
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                arr[i][j] = copyMap[i][j];
            }
        }
    }
    public void dfs(int cnt, int[][] arr){
        if(cnt >=3){
            virus(arr);
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(arr[i][j]==0){
                    arr[i][j]=1;
                    dfs(cnt+1, arr);
                    arr[i][j] = 0;
                }
            }
        }

    }

    public void print(int arr[][]){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int arr[][] = new int[N][M];
        visit = new int[N][M];
//        int visit[][] = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = sc.nextInt();
//                if(arr[i][j] == 2 || arr[i][j] == 1){
//                    visit[i][j] = 1;
//                }
            }
        }
        Solution21 sol = new Solution21();
        sol.dfs(0, arr);

        System.out.println(ans);
    }
}
