package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/13549
//숨바꼭질 3
public class Solution95 {

    static int N,K;
    static int visit[] = new int[100001];
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visit[N] = 1;

        while(!q.isEmpty()){
            int x = q.poll();
            if(x==K){
                return;
            }
            for(int i=0; i<3; i++){
                int xx;
                if(i==0){
                    xx = x+1;
                }else if(i==1){
                    xx = x-1;
                }else{
                    xx = x*2;
                }
                if(xx<0 || xx>100000) {
                    continue;
                }
                if(visit[xx]==0){
                    if(i==2){
                        visit[xx]= visit[x];
                    }else{
                        visit[xx] = visit[x]+1;
                    }
                    q.add(xx);
                }else{
                    if(i==2) {
                        if(visit[xx] > visit[x]){
                            visit[xx] = visit[x];
                            q.add(xx);
                        }
                    }else{
                        if(visit[xx] > visit[x]+1){
                            visit[xx] = visit[x] +1;
                            q.add(xx);
                        }
                    }
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(visit[K]-1);

    }
}
