package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1654
//랜선자르기
public class Solution73 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        long max = -1;
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());

            if(max <arr[i]){
                max = arr[i];
            }
        }
        long min = 0;
        long ans = 0;
        while(min <= max) {
            long mid = (max+min)/2;
            if(mid==0){
                mid = 1;
            }
            long cnt = 0;
            for(int i=0; i<K; i++){
                cnt += arr[i]/mid;
            }
            if(cnt<N){

                max = mid-1;
            }else{
                min = mid +1;
            }

        }
        System.out.println(min-1);
    }
}
