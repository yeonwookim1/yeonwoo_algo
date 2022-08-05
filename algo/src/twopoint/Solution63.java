package twopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2003
//2003 수들의합 2
public class Solution63 {
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

        int start =0,end =0;
        int sum = 0;
        int ans = 0;
        while(end<=N){
            if(sum <M){ //end는 인덱스를 넘어섰지만, start가 아직 남아서 sum을 체크해야될 수 있다.
                if(end >=N){
                    break;
                }
                sum += arr[end];
                end++;
            }else{
                sum -= arr[start];
                start++;
            }

            if(sum == M){
                ans++;
            }

        }
        System.out.println(ans);
    }
}
