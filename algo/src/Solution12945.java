public class Solution12945{

    int[] dp;
    public int fibo(int n){
        if(n==0){
            return dp[0];
        }
        if(n==1){
            return dp[1];
        }
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        dp[n] = (fibo(n-1) + fibo(n-2))%1234567;
        return dp[n];
    }

    public int solution(int n) {
        int answer = 0;
        dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;
        

        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }
        answer = dp[n];


        //answer = fibo(n);
        return answer;
    }

    public static void main(String[] args) {
        new Solution12945().solution(10);
    }
}