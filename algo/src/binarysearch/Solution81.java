package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7795
//먹을 것인가 먹힐 것인가
public class Solution81 {

    public static int findIdx(int num, int[] arr){

        int start =1;
        int end = arr.length-1;
        int cnt = 0;
        while(start<=end){
            int mid = (start+end)/2;

            if(num <= arr[mid]){
                end = mid -1;
            }else if(num > arr[mid]){
                cnt = mid;  //작은것들을 count
                start = mid +1;
//                if(num==arr[mid]){
//                    return mid;
//                }
            }
        }


        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while(T>0){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int arrA[] = new int[N+1];
            int arrB[] = new int[M+1];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++){
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<M; i++){
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrB);

            int ans = 0;
            for(int i=0; i<N; i++){
                int idx = findIdx(arrA[i],arrB);
                ans += idx;
            }
            System.out.println(ans);


            T--;
        }


    }
}
