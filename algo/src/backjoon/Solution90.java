package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/5014
//스타트링크
public class Solution90 {
    static int F,G,D,U,S;
    static int visit[];
    static int max = Integer.MAX_VALUE;

    static class Point{
        int now;
        int step;
        public Point(int now, int step){
            this.now = now;
            this.step = step;
        }
    }
    static void bfs(int stair){
        int dx[] = {U,-D};
        Queue<Point> q = new LinkedList<>();
        visit[stair] = 1;
        q.add(new Point(stair, 0));
        while(!q.isEmpty()){
            int now = q.peek().now;
            int step = q.peek().step;
            q.poll();
            if(now == G){
                max = Math.min(max,step);
            }
            for(int i=0; i<2; i++){
                int nowX = now + dx[i];
                if(nowX<=0 || nowX >F){
                    continue;
                }
                if(visit[nowX] == 0){
                    q.add(new Point(nowX, step+1));
                    visit[nowX] = 1;
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visit = new int[F+1];

        bfs(S);

        if(max == Integer.MAX_VALUE){
            System.out.println("use the stairs");
        }else{
            System.out.println(max);
        }

    }

}
