package dp;

import java.util.Scanner;

public class Solution36 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        int arr[] = new int[N+1];

        for(int i=1; i<=N; i++){
            int M = sc.nextInt();
            arr[i] = M;
        }

        int dp[] = new int[N+1];
        dp[1] = arr[1];
        for(int i=2; i<=N; i++){
            for(int j=1; i-j>=0; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
            }
        }

        System.out.println(dp[N]);

    }
}
