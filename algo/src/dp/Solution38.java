package dp;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution38 {
    static int N;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();

        long dp[] = new long[N + 1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=2; i<=N; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[N]);
    }
}
