package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/13913
//숨바꼭질 4
public class Solution94 {

    static int N,K;
    static int visit[];
    static int min;
    static int[] parent = new int[100001];

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        visit[x] = 1;
        q.add(x);
        while(!q.isEmpty()){
            int xx = q.peek();
            q.poll();
            if(xx==K){
                return;
            }
            for(int i=0; i<3; i++){
                int next=0;
                if(i==0){
                    next = xx +1;
                }else if(i==1){
                    next = xx -1;
                }else{
                    next = xx*2;
                }
                if(next <0 || next>100000){
                    continue;
                }

                if(visit[next]==0){
                    visit[next]=visit[xx]+1;
                    q.add(next);
                    parent[next] = xx;
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
        min = Integer.MAX_VALUE;
        visit = new int[100001];
        bfs(N);

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(visit[K] - 1 + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }
}
