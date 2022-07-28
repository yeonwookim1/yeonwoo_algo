package dp;

import java.util.Scanner;

//https://www.acmicpc.net/problem/12865
public class Solution31 {
    static int N;
    static int K;
    static int dp[][];
    static int items[];
    static int values[];

    static int dp(int i, int k){
        if(i<=0 || k<=0){
            return 0;
        }

        if(items[i] >k){
            dp[i][k] = dp[i-1][k];
        }else{
            dp[i][k] = Math.max(dp(i-1,k), dp(i-1, k-items[i]) + values[i]);
        }
        return dp[i][k];

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        items = new int[N+1];
        values = new int[N+1];
        dp = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            items[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        System.out.println(dp(N,K));


//        //top
//
//        for(int i=0; i<=N; i++){
//            for(int j=0; j<=K; j++){
//                if(i==0 || j==0){
//                    dp[i][j] = 0;
//                }else{
//                    if(items[i] >j) {
//                        dp[i][j] = dp[i-1][j];
//                    }else{
//                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i]] + values[i]);
//                    }
//                }
//            }
//        }
//
//        System.out.println(dp[N][K]);
    }
}
