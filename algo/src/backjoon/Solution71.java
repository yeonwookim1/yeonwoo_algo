package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/8958
//OX퀴즈
public class Solution71 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int cnt = 1;
        int ans =0;
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a==0){
                cnt = 1;
            }else{
                ans += cnt;
                cnt++;
            }

        }

        System.out.println(ans);

    }
}
