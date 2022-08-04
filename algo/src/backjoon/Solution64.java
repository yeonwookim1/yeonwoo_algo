package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1806
//1806 부분합
public class Solution64 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MAX_VALUE;

        int start = 0;
        int end =0;
        int sum = 0;
        while(end<=N){
            if(sum>=M){
                ans = Math.min(ans, end - start);
                sum -= arr[start];
                start++;
//                ans = Math.min(ans, end - start +1);
            } else{
                if(end>=N){
                    break;
                }
                sum += arr[end];
                end++;
            }
        }
        if(ans == Integer.MAX_VALUE){
            ans = 0;
        }
        System.out.println(ans);

    }
}
