package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2512
//예산
public class Solution79 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[N];

        int max = -1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if(max < arr[i]){
                max = arr[i];
            }
            if(min > arr[i]){
                min = arr[i];
            }
        }
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        if(sum<=M){
            System.out.println(max);
            return;
        }

        int start = 0;
        int end = max;
        int ans = 0;
        while(start<=end){
            int mid = (start+end) /2;
            int cnt = 0;
            for(int i=0; i<N; i++){
                if(arr[i]<=mid){
                    cnt += arr[i];
                }else{
                    cnt += mid;
                }
            }

            if(cnt<M){
                start = mid +1;
                ans = mid;
            }else if(cnt == M){
                ans = mid;
                break;
            }else{
                end = mid -1;
            }
        }

        System.out.println(ans);

    }
}
