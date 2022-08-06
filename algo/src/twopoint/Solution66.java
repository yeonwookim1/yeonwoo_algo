package twopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2003
//수들의합2
public class Solution66 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end= 0;
        int ans = 0;
        int sum = 0;
        while(end<=N){
            if(sum<M){
                if(end>=N){
                    break;
                }
                sum += arr[end];
                end++;
            }else if(sum>=M){
                sum -= arr[start];
                start++;
            }
            if(sum==M){
                ans++;
            }
        }
        System.out.println(ans);

    }
}

