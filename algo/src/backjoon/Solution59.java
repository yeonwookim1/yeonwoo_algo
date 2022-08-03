package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2003
//수들의 합
public class Solution59 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i=0; i<N; i++) {
            int cnt = 0;
            for(int j=i; j<N; j++){
                cnt += arr[j];

                if(cnt==M){
                    ans++;
                    break;
                }
                if(cnt>M){
                    break;
                }
            }
        }

        System.out.println(ans);

    }
}
