package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Solution40 {
    static int N;
    static int arr[];

    public static boolean bSearch(int target, int head, int tail){
        if(head>tail){
            return false;
        }
        int mid = (head+tail)/2;
        if(arr[mid] ==target){
            return true;
        } else if(arr[mid] > target){
            return bSearch(target, head,mid-1);
        }else{
            return bSearch(target,mid+1, tail);
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        Arrays.sort(arr);
        for(int i=0; i<M; i++){
            int temp = sc.nextInt();
            if(bSearch(temp,0,arr.length-1)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
