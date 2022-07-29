package programmers;

import java.util.*;

//+1칸은 건전지 비용 +1
//기존칸 *2로 이동하면 건전지 비용X
//n=5 answer = 5
//n=6 answer = 2
//n=5000 answer = 5
public class Solution46 {
    public int solution(int n) {
        int ans = 0;
        // int dp[] = new int[n+1];
        // dp[1] = 1;
        // for(int i=2; i<n+1; i++){
        //     if(i%2 ==0){
        //         dp[i] = Math.min((dp[i-1] +1), dp[i/2]);
        //     }else{
        //         dp[i] = dp[i-1] +1;
        //     }
        // }
        // ans = dp[n];
        while(n>0){
            if(n%2 != 0){
                ans++;
            }
            n = n/2;
        }
        return ans;
    }
}