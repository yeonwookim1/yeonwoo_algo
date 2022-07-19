import java.util.Scanner;

public class Solution29 {
    static int N;
    static int M;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int arr[][];

    static class Car{
        int x,y,dir;
        public Car(int x, int y, int dir){
            this.x= x;
            this.y = y;
            this.dir = dir;
        }

        public void print(int arr[][]){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int answer = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];

        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        Car car = new Car(r,c,d);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int cnt=0; //4방향 체크용
        while(true){
            int x = car.x;
            int y = car.y;
            int dir = car.dir;

            if (cnt == 4) {
                int xx = x + dx[(dir + 2) % 4];
                int yy = y + dy[(dir + 2) % 4];
                if (xx < 0 || yy < 0 || yy >= M || xx >= N ||arr[xx][yy] == 1) {
                    break;
                }
                car.x = xx;
                car.y = yy;
                cnt = 0;
                continue;
            }

            if(arr[x][y] ==0){
                arr[x][y] =2;
                answer++;
            }

            int ddir = (dir+3)%4;
            int xx = x + dx[ddir];
            int yy = y + dy[ddir];
            car.dir = ddir;
            if(xx<0 || yy<0 || xx>=N || yy>=M){
                continue;
            }
            if(arr[xx][yy]==0){
                car.x = xx;
                car.y =yy;
                cnt=0;
            }else{
                cnt++;
            }

        }
        System.out.println(answer);
    }
}
