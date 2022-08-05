package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2293
//동전 1
public class Solution69 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int dp[][] = new int[N+1][M+1];
        int coin[] = new int[N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=N; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=M; i++){
            if(i%coin[1] == 0){
                dp[1][i] = 1;
            }

        }

        for(int i=2; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(j-coin[i] >=0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        System.out.println(dp[N][M]);
//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=M; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
}
