package dp;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1463
//1로만들기
public class Solution33 {
    static int N;
    static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();

        arr = new int[N+1];
        arr[1] = 0;
        for(int i=2; i<=N; i++){
            //전꺼의 +1
            arr[i] = arr[i-1]+1;

            if(i%2 == 0 && arr[i/2] < arr[i]){
                arr[i] = arr[i/2] +1;
            }
            if(i%3 == 0 && arr[i/3] < arr[i]){
                arr[i] = arr[i/3] +1;
            }

        }

//        for(int i=2; i<=N; i++){
//            int x= 9999999;
//            int y = 9999999;
//            int z = i-1;
//            if(i%3==0 && i%2 ==0){
//                x = i/3;
//                y = i/2;
//                arr[i] = 1 + Math.min(arr[z],Math.min(arr[x],arr[y]));
//                continue;
//            }
//            if(i%3 == 0){
//                x = i/3;
//                arr[i] = 1 +Math.min(arr[x],arr[z]);
//                continue;
//            }
//            if(i%2 == 0){
//                y = i/2;
//                arr[i] = 1 +Math.min(arr[y],arr[z]);
//                continue;
//            }
//            arr[i] = arr[z] +1;
//        }
        System.out.println(arr[N]);

    }
}
