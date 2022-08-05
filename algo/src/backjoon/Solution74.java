package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//https://www.acmicpc.net/problem/2805
//나무자르기
public class Solution74 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        long max = -1;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){

            arr[i] =  Integer.parseInt(st.nextToken());
            if(max < arr[i]){
                max = arr[i];
            }
        }

        long ans = 0;
        long min = 0;
        while(min<=max){
            long mid = (min+max)/2;
            long cnt =0;
            for(int i=0; i<N; i++){
                long temp = arr[i] - mid;
                if(temp >=0){
                    cnt += temp;
                }
            }

            if(cnt > M ){
                min = mid +1;
                ans = mid;
            }else if(cnt < M){
                max = mid-1;
            }else{
                ans = mid;
                break;
            }

        }
        System.out.println(ans);

    }
}
