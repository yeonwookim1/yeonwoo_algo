package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10816
//숫자 카드2
public class Solution72 {
    public static int lowerSearch(int[]arr, int target){
        boolean isExist = false;
        int start =0;
        int end = arr.length;

        while(end>start){
            int mid = (end+start)/2;

            if(arr[mid]>=target){
                end = mid;
                if(arr[mid]==target){
                    isExist = true;
                }
            }else{
                start = mid +1;
            }
        }
        if(isExist){
            return start;
        }else{
            return -1;
        }

    }

    public static int upperSearch(int[]arr, int target){
        boolean isExist = false;
        int start = 0;
        int end = arr.length;
        while(end>start){
            int mid = (end+start)/2;
            if(arr[mid]>target){
                end = mid;
            }else{
                start = mid+1;
                if(arr[mid]==target){
                    isExist = true;
                }
            }
        }
        if(isExist){
            return start;
        }else{
            return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int arr2[] = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<M; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
           int lowerIdx = lowerSearch(arr,arr2[i]);
           int upperIdx = upperSearch(arr,arr2[i]);
//            System.out.println(lowerIdx + " " + upperIdx);
            if(upperIdx != -1 && lowerIdx != -1){
                sb.append(upperIdx-lowerIdx + " ");
            }else{
                sb.append("0 ");
            }


        }

        System.out.println(sb.toString());


    }
}
