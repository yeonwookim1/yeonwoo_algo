package twopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2230
//수고르기
public class Solution62 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;

        while(end<N){
            int temp = Math.abs(arr[start]-arr[end]);
            if(temp < M){
                end++;
                continue;
            }
            if(temp==M){
                ans = temp;
                break;
            }
            ans = Math.min(ans,temp);
            start++;
        }


        System.out.println(ans);
    }
}
