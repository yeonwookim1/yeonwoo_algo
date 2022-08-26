package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16194
//카드구매하기 2
public class Solution92 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int value[] = new int[N+1];
        int dp[][] = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=N; i++){
            dp[0][i] = 0;
            dp[i][0] = 0;
            if(i>0) {
                dp[1][i] = value[1]*i;
            }
        }

        for(int i=2; i<=N; i++){
            for(int j=1 ; j<=N; j++){
                if(j-i<0){
                    dp[i][j] = dp[i-1][j];
                }else{
//                    if(dp[i-1][j] == 0){
//                        dp[i][j] = dp[i][j-i] + value[i];
//                    }else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i] + value[i]);
//                    }
                }
            }
        }
        System.out.println(dp[N][N]);
//        for(int i=1; i<=N; i++){
//            for(int j=1 ; j<=N; j++) {
//                System.out.print(dp[i][j] +" ");
//            }
//            System.out.println();
//        }


    }
}
