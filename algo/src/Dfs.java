public class Dfs {
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    public int lenX;
    public int lenY;
    public int[][] visit;
    public int answer;

    public class Point{
        int x;
        int y;
        int cnt;
        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }


    public void dfs(int x, int y, int cnt, int[][] maps){
        if(x == lenX-1 && y == lenY-1){
            if(answer > cnt){
                answer = cnt;
                return;
            }
        }
        for(int i=0; i<4; i++){
            int xx = x + dx[i];
            int yy = y +dy[i];
            if(xx<0 || xx>=lenX || yy<0 || yy>=lenY){
                continue;
            }
            if(visit[xx][yy] == 0 && maps[xx][yy] ==1){
                visit[xx][yy] = 1;
                dfs(xx,yy,cnt+1, maps);
                visit[xx][yy] = 0;

            }
        }
    }


    public int solution(int[][] maps) {
        answer = 999999;
        lenX = maps.length;
        lenY = maps[0].length;
        visit = new int[lenX][lenY];
        visit[0][0] = 1;
        dfs(0,0,1,maps);


        System.out.println(answer);

        if(answer == 999999){
            answer = -1;
        }
        return answer;
    }


    public static void main(String[] args) {
        Dfs s3 = new Dfs();
        int[][] test = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        s3.solution(test);

    }
}
