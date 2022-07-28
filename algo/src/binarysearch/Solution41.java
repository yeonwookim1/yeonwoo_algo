package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution41 {

    static int arr[];
    public static int bSearch(int target, int head, int tail){
        if(head>tail){
            return 0;
        }
        int mid = (head+tail)/2;
        if(arr[mid] == target){
            return 1;
        }else if(arr[mid] > target){
            return bSearch(target, head, mid-1);
        } else{
            return bSearch(target,mid+1, tail);
        }

//        int head = 0;
//        int tail = arr.length-1;
//
//        while(head<=tail){
//            int mid = (head+tail)/2;
//            if(arr[mid]==target){
//                return 1;
//            } else if(arr[mid] >target){
//                tail = mid-1;
//            }else{
//                head = mid+1;
//            }
//        }
//        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            System.out.println(bSearch(temp,0,arr.length-1));
        }
    }

}
