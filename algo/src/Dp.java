import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Dp {
    public static int[] dp = new int[50];

    public int fibo(int n){
        if(n == 0){
            dp[0] = 0 ;
            return 0;
        } else if(n == 1){
            dp[1] = 1;
            return 1;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        return dp[n] = fibo(n-1) + fibo(n-2); 
    }

    public int cal(int n){
        if(n<=3){
            return dp[n];
        }

        return dp[n] = cal(n-1) + cal(n-2) + cal(n-3);
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 0;
        T = Integer.parseInt(br.readLine());
        Dp.dp[1] = 1;
        Dp.dp[2] = 2;
        Dp.dp[3] = 4;
        while(T>0){
           int n = Integer.parseInt(br.readLine());
           
           for(int i=4; i<=n; i++){
               Dp.dp[i] = Dp.dp[i-1] + Dp.dp[i-2] + Dp.dp[i-3];
           }
           System.out.println(Dp.dp[n]);

            T--;
        }
    }
}
