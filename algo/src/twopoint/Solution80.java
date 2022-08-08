package twopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1912
//연속합
public class Solution80 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /*
        int max = -10000;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end<N){
            sum += arr[end];
            max = Math.max(sum,max);

            if(sum <0){
                start = end +1;
                end = start;
                if(start==N){
                    break;
                }
                sum =0;
            }else{
                end++;
            }
        }
        max = Math.max(sum,max);
        */

        int max = -10000;
        int dp[]= new int[N];
        dp[0] = arr[0];
        for(int i=1; i<N; i++){
            dp[i] = Math.max(arr[i],dp[i-1]+arr[i]);
        }
        Arrays.sort(dp);
        System.out.println(dp[N-1]);
    }
}
