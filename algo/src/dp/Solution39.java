package dp;

import java.util.Scanner;

public class Solution39 {
    static int N;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        long dp[][] = new long[N+1][10];

        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                if(j==0){
                    dp[i][0] = dp[i-1][1]%1000000000;
                }else if(j==9){
                    dp[i][9] = dp[i-1][8]%1000000000;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
                }

            }
        }

        long ans = 0L;
        for(int i=0; i<10; i++){
            ans+=dp[N][i];
        }
        System.out.println(ans);

    }
}
