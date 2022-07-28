package dp;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2747
public class Solution32 {
    static int N;
    static int dp[];
    static int dp(int n){
        if(n == 0){
            return dp[0] = 0;
        }
        if(n==1){
            return dp[1] = 1;
        }
        return dp[n] = dp(n-2) + dp(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        dp = new int[N+1];
        //top
        //시간초과
        System.out.println(dp(N));

        //bottom
//        dp[0] = 0;
//        dp[1] =1;
//        for(int i=2; i<=N; i++){
//            dp[i] = dp[i-2] + dp[i-1];
//        }
//
//        System.out.println(dp[N]);

    }
}
