package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution102 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[]= new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        long min = 0;
        long max = -1;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]){
                max = arr[i];
            }
        }
        long ans = 0;
        while(min<=max){
            long mid = (min+max)/2;
            long sum = 0;
            for(int i=0; i<arr.length; i++){
                long temp = arr[i] - mid;
                if(temp>0){
                    sum += temp;
                }
            }
            if(sum<M){
                max = mid-1;
            }else{
                min = mid+1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}
