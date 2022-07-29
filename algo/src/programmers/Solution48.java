package programmers;
import java.util.Queue;
import java.util.LinkedList;

//https://school.programmers.co.kr/learn/courses/30/lessons/1829
//카카오프렌즈 컬러링북

public class Solution48 {
    static int m,n;
    static int[][] visit;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    class Point{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int bfs(int[][] arr, int a, int b){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(a,b));
        int cnt = 0;
        int target = arr[a][b];
        visit[a][b] = 1;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            cnt++;
            for(int i=0; i<4; i++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx<0 || xx>=m || yy<0 || yy>=n){
                    continue;
                }

                if(arr[xx][yy] == target && visit[xx][yy] ==0){
                    visit[xx][yy]=1;
                    q.add(new Point(xx,yy));
                }

            }
        }

        return cnt;
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        this.m = m;
        this.n =n;
        this.visit = new int[m][n];

        int[] answer = new int[2];

        maxSizeOfOneArea = -1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visit[i][j] == 0 && picture[i][j]!=0){
                    int cnt = bfs(picture, i, j);
                    numberOfArea++;
                    if(maxSizeOfOneArea < cnt){
                        maxSizeOfOneArea = cnt;
                    }
                }
            }
        }
        //몇개의 영역이 있는지 -> bfs에서 return
        //가장 큰 영역 -> 따로 저장

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        // System.out.println(answer[0]);
        // System.out.println(answer[1]);
        return answer;
    }
}
