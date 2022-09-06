package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1715
//카드 정렬하기
public class Solution104 {

    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            q.add(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;

        while(q.size() >1){
            int x = q.poll();
            int y = q.poll();
            q.add(x+y);
            answer+= (x+y);
        }

        System.out.println(answer);
    }
}
