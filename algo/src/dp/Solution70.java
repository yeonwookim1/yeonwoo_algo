package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution70 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int dp[][] = new int[N + 1][M + 1];
        int weight[] = new int[N+1];
        int value[] = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(j-weight[i] >=0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
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
