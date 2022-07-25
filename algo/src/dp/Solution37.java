package dp;

import java.util.Scanner;

public class Solution37 {
    static int N;
    static int K;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int w[] = new int[N+1];
        int v[] = new int[N+1];

        for(int i=1; i<=N; i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int dp[][] = new int[N+1][K+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(j>=w[i]){
                    dp[i][j] = Math.max(dp[i-1][j], v[i]+dp[i-1][j-w[i]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

        System.out.println(dp[N][K]);

    }
}
