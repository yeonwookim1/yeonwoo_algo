import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};

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

    public int solution(int[][] maps) {
        int answer = -1;
        
        int lenX = maps.length;
        int lenY = maps[0].length;
        int[][] visit = new int[lenX][lenY];
        

        visit[0][0] = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,1));
        while(!queue.isEmpty()){
            int x = queue.peek().x;
            int y = queue.peek().y;
            int cnt = queue.peek().cnt;
            queue.poll();
            if(x==lenX-1 && y == lenY -1){
                answer = cnt;
                break;
            }
            for(int i=0; i<4; i++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx <0 || xx>= lenX || yy < 0 || yy >= lenY){
                    continue;
                }
                if(visit[xx][yy] == 0 && maps[xx][yy] == 1){
                    queue.add(new Point(xx, yy, cnt+1));
                    visit[xx][yy] = 1;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Bfs s3 = new Bfs();
        int[][] test = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        
        System.out.println(s3.solution(test));

    }
}
