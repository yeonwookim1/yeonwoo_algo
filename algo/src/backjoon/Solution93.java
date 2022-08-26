package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15990
//1,2,3 더하기 5

public class Solution93 {
    static class Point{
        long x,y,z;
        public Point(long x, long y, long z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Point dp[] = new Point[100001];
        dp[1] = new Point(1,0,0);
        dp[2] = new Point(0,1,0);
        dp[3] = new Point(1,1,1);

        List<Integer> list = new ArrayList<>();
        int max = -1;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            max = Math.max(max,temp);
            list.add(temp);
        }
        for(int i=4; i<=max; i++){
            long three = (dp[i-3].x)%1000000009 + (dp[i-3].y)%1000000009;

            long two = (dp[i-2].x)%1000000009 + (dp[i-2].z)%1000000009;

            long one = (dp[i-1].y)%1000000009 + (dp[i-1].z)%1000000009;

            dp[i] = new Point(one%1000000009,two%1000000009,three%1000000009);
//            System.out.println(dp[i].value);
//            System.out.println(one + " " + two + " " + three);
        }

        for(int a : list){
            System.out.println((dp[a].x + dp[a].y + dp[a].z)%1000000009);
        }
    }
}
