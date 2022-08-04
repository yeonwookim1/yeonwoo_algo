package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        int temp =0;
        int ans = 0;
        while(end<N){
            System.out.println(temp);
            if(temp >= M){
                temp -= arr[start];
                start++;
            }else if(end >=N){
                break;
            } else{
                temp += arr[end];
                end++;
            }

            if(temp==M){
                ans++;
            }


        }
        System.out.println(ans);
    }
}
