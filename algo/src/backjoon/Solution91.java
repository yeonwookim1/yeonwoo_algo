package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1260
//DFS와 BFS
public class Solution91 {

    static int N,M,V;
    static int visit[];
    static int arr[][];
    static List<Integer> list;
    static void dfs(int x){
        for(int i=1; i<=N; i++){
            if(arr[x][i] ==1 && visit[i] == 0){
                visit[i] = 1;
                list.add(i);
                dfs(i);
            }
        }

    }

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = 1;
        while(!q.isEmpty()){
            int xx = q.poll();
            for(int i=1; i<=N; i++) {
                if(arr[xx][i] == 1 &&visit[i]==0){
                    visit[i]=1;
                    q.add(i);
                    list.add(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visit = new int[N+1];
        arr = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=N; j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }

        StringBuffer sb = new StringBuffer();
        list= new ArrayList<>();
        list.add(V);
        visit[V] = 1;
        dfs(V);

        for(int a : list){
            sb.append(a + " ");
        }
        sb.append("\n");

        init();

        list.add(V);
        bfs(V);
        for(int a : list){
            sb.append(a + " ");
        }
        System.out.println(sb.toString());
    }
    static void init(){
        while(!list.isEmpty()){
            list.remove(0);
        }

        for(int i=0; i<visit.length; i++){
            visit[i] = 0;
        }
    }
}
